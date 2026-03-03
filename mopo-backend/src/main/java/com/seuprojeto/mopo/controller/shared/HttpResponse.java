package com.seuprojeto.mopo.controller.shared;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public record HttpResponse(
        int httpStatus,
        Object content,
        String message
) {

    public static HttpResponse of(HttpStatus status, Object content, String message) {
        return new HttpResponse(status.value(), content, message);
    }

    public static HttpResponse of(HttpStatus status, String message) {
        return new HttpResponse(status.value(), null, message);
    }

    public static HttpResponse of(HttpStatus status) {
        return new HttpResponse(status.value(), null, null);
    }

    public ResponseEntity<HttpResponse> toResponseEntity() {
        return ResponseEntity
                .status(this.httpStatus)
                .body(this);
    }
}