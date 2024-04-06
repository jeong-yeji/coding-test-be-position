package com.example.api.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    FOOD_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 식품영양성분 정보가 존재하지 않습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
