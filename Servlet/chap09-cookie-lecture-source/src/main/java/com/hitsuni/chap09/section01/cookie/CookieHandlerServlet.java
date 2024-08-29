package com.hitsuni.chap09.section01.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cookie")
public class CookieHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        System.out.println("firstName : " + firstName + ", lastName : " + lastName);

        /* 1. 쿠키 생성 */
        Cookie firstNameCookie = new Cookie("firstName", firstName);
        Cookie lastNameCookie = new Cookie("lastName", lastName);

        /* 2. 쿠키 만료 시간 설정 */
        firstNameCookie.setMaxAge(60 * 60 * 24); // 초 단위이며 하루를 만료 시간으로 하는 예시
        lastNameCookie.setMaxAge(60 * 60 * 24);

        /* 3. 응답 헤더에 쿠키를 담는다. */
        resp.addCookie(firstNameCookie);
        resp.addCookie(lastNameCookie);

        /* 4. 응답 처리 */
        resp.sendRedirect("redirect");
    }
}
