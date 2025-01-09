package com.spring.reactive.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class ApiResponse<T> {
    private String status;
    private String message;
    private T data;
    private int code;

    // Default constructor
    public ApiResponse() {}

    // Constructor for success response
    public ApiResponse(String status, String message, T data, int code) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.code = code;
    }

    // Getter and setter methods
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    // Static method for success response
    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>("success", message, data, 200);
    }

    // Static method for failure response
    public static <T> ApiResponse<T> failure(String message, T data) {
        return new ApiResponse<>("failure", message, data, 400);
    }
}
