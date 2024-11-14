package me.assetaid.feature.click.application.dto;

public class ClickResponseDTO {
    private boolean success;
    private String message;
    private int statusCode;

    public ClickResponseDTO(boolean success, String message, int statusCode) {
        this.success = success;
        this.message = message;
        this.statusCode = statusCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
