package com.example.api.global.exception;

import lombok.Builder;

@Builder
public record ErrorResponse(String code, String message) {

}
