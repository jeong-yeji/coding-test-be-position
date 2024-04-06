package com.example.api.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum CustomErrorCode implements ErrorCode{

    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
