package com.hitsuni.chap11.section02.users;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class RequestWrapper extends HttpServletRequestWrapper {

    /* 생성자가 반드시 있어야 함. */
    public RequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        String value = "";
        if("password".equals(name)) {
            // 비밓번호 암호화 처리한 값으로 변경한다.
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            passwordEncoder.encode(super.getParameter(name));
        } else {
            value = super.getParameter(name);
        }
        return value;
    }
}
