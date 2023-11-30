package com.joonfluence.starbucks.global.dto;

import lombok.Getter;

@Getter
public enum ResponseMessage {
    LOGIN_SUCCESS("로그인 성공"),
    LOGIN_FAIL("로그인 실패"),
    READ_USER("회원 정보 조회 성공"),
    READ_POST("게시글 조회 성공"),
    CREATE_POST("게시글 생성 성공"),
    UPDATE_POST("게시글 수정 성공"),
    DELETE_POST("게시글 삭제 성공"),
    NOT_FOUND_USER("회원을 찾을 수 없습니다."),
    CREATED_USER("회원 가입 성공"),
    UPDATE_USER("회원 정보 수정 성공"),
    DELETE_USER("회원 탈퇴 성공"),
    INTERNAL_SERVER_ERROR("서버 내부 에러"),
    DB_ERROR("데이터베이스 에러");

    String message;

    ResponseMessage(String message) {
        this.message = message;
    }
}
