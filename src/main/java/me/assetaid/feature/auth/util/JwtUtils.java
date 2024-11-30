package me.assetaid.feature.auth.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private long jwtExpiration;

    // JWT 토큰 생성
    public String generateToken(String userId) {
        // 비밀 키로부터 Key 객체 생성
        Key key = Keys.hmacShaKeyFor(jwtSecret.getBytes());

        // JWT 토큰 생성
        return Jwts.builder()
                .setSubject(userId)  // 사용자 ID를 Subject로 설정
                .setIssuedAt(new Date())  // 발급 시간
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))  // 만료 시간
                .signWith(key, SignatureAlgorithm.HS256)  // 비밀 키로 서명
                .compact();
    }

}
