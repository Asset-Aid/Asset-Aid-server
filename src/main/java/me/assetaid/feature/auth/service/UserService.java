package me.assetaid.feature.auth.service;

import me.assetaid.feature.auth.application.dto.LoginRequestDTO;
import me.assetaid.feature.auth.application.dto.RegisterRequestDTO;
import me.assetaid.feature.auth.repository.UserRepository;
import me.assetaid.feature.auth.repository.entity.UserEntity;
import me.assetaid.feature.auth.response.LoginResponse;
import me.assetaid.feature.auth.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RedisTemplate<String, String> redisTemplate;
    private final JwtUtils jwtUtils; // JwtUtils를 주입받음

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder,
                       RedisTemplate<String, String> redisTemplate, JwtUtils jwtUtils) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.redisTemplate = redisTemplate;
        this.jwtUtils = jwtUtils;
    }

    // 로그인 처리 메소드
    public LoginResponse login(LoginRequestDTO loginRequestDTO) {
        // DB에서 사용자 정보 조회
        UserEntity user = userRepository.findByUserId(loginRequestDTO.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 비밀번호 확인
        if (!passwordEncoder.matches(loginRequestDTO.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        // JWT 토큰 생성
        String token = jwtUtils.generateToken(user.getUserId());

        return new LoginResponse(token, "Login successful", true);
    }

    // 회원 가입 처리 메소드
    public void register(RegisterRequestDTO registerRequestDTO) {
        if (userRepository.existsByUserId(registerRequestDTO.getId())) {
            throw new RuntimeException("ID already exists");
        }

        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(registerRequestDTO.getPassword());

        // 사용자 정보 저장
        UserEntity userEntity = new UserEntity(registerRequestDTO.getId(), encodedPassword, registerRequestDTO.getNickname(), registerRequestDTO.getBirthday());
        userRepository.save(userEntity);
    }

    // 로그아웃 처리
    public void logout(String token) {
        // Redis에 토큰을 블랙리스트로 추가
        redisTemplate.opsForValue().set("blacklist:" + token, "true");

        System.out.println("Token " + token + " is now blacklisted.");
    }

    // ID 중복 체크
    public void checkId(String userId) {
        if (userRepository.existsByUserId(userId)) {
            throw new RuntimeException("ID already exists");
        }
    }

    // 비밀번호 확인
    public void checkPassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new RuntimeException("Password cannot be empty");
        }

        // 비밀번호 최소 길이, 대소문자, 숫자, 특수문자 포함 여부 등 추가 확인 로직
        if (password.length() < 8) {
            throw new RuntimeException("Password must be at least 8 characters long");
        }
        //대문자 포함 여부 체크
        if (!password.matches(".*[A-Z].*")) {
            throw new RuntimeException("Password must contain at least one uppercase letter");
        }
        //숫자 포함 여부 체크
        if (!password.matches(".*\\d.*")) {
            throw new RuntimeException("Password must contain at least one digit");
        }
        //특수문자 포함 여부 체크
        if (!password.matches(".*[!@#$%^&*].*")) {
            throw new RuntimeException("Password must contain at least one special character");
        }
    }

    // 회원 탈퇴 처리
    public void leave(String userId) {
        UserEntity user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userRepository.delete(user);  // 사용자 삭제
    }
}
