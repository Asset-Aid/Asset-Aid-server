package me.assetaid.feature.auth.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {

    private String token;
    private String message;
    private boolean success;

    public LoginResponse(String token, String message, boolean success) {
        this.token = token;
        this.message = message;
        this.success = success;
    }
}
