package com.hitsuni.exceptionhandler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/* @ControllerAdvice : 해당 어노테이션이 적용 된 클래스의 @ExceptionHandler 는 전역적으로 기능한다. */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(NullPointerException e) {
        System.out.println("전역 범위의 Exception Handler 동작");
        System.out.println("message : " + e.getMessage());

        return "error/nullPointer";
    }

    @ExceptionHandler(MemberRegisterException.class)
    public String memberRegisterExceptionHandler(MemberRegisterException e, Model model) {
        System.out.println("전역 범위의 Exception Handler 동작");
        model.addAttribute("exception", e);
        return "error/memberRegister";
    }

    /* 상위 타입의 Exception 을 통해 Handler 를 작성하면 하위 타입의 모든 Exception 을 처리할 수 있다. */
    @ExceptionHandler(Exception.class)
    public String defaultExceptionHandler(Exception e) {
        return "error/default";
    }
}
