package com.hitsuni.chap07.section01.forward;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/print")
public class PrintLoginSuccessServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* forward 된 서블릿에서도 요청 방식이 그대로 유지가 된다. (post -> post)
        * 전달 된 req, resp 의 모든 정보를 이용해 새로운 req, resp 를 깊은 복사를 통해 만들어 전달하므로
        * 데이터가 그대로 유지 되고 있다.
        *  */

        /* parameter : 클라이언트에서 전송된 데이터
        * attribute : request 객체가 가지는 속성으로 request 가 유지되는 동안 데이터가 보존된다.
        * */
        String userName = (String)req.getAttribute("userName");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>" + userName + "님 환영합니다. </h1>");
        out.flush();
        out.close();
    }
}
