package com.hitsuni.exceptionhandler;

/* 사용자 정의 Exception 클래스 */
public class MemberRegisterException extends Exception {

    /* 메시지를 좀 다루고 싶다면 생성자가 필요하다. */
    public MemberRegisterException(String message) {
        super(message);
    }
}
