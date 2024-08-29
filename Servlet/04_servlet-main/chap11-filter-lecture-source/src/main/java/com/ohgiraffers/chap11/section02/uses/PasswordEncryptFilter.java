package com.ohgiraffers.chap11.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter("/member/*")
public class PasswordEncryptFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        RequestWrapper requestWrapper = new RequestWrapper(request);
        // member와 관련한 기능은 기존 request 객체를 RequestWrapper 객체로 감싸서 서블릿으로 전달한다.
        // RequestWrapper에서 오버라이딩한 메소드가 기능하게 된다.
        filterChain.doFilter(requestWrapper, servletResponse);
    }
}
