package com.hitsuni.chap07.section01.forward;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/forward")
public class ReceiveInformationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");

        /* id와 pwd 에 해당하는 user 의 정보를 select 하고 오는 비즈니스 로직이 수행 되어야 한다.
        * 해당 로직이 정상 수행 되었다는 가정 하에 'XXX 님 환영합니다.' 와 같은 메시지 출력 화면을 응답한다.
        *  */
        req.setAttribute("userName", "홍길동");

        /* 다른 서블릿으로 forward */
        RequestDispatcher rd = req.getRequestDispatcher("print");
        rd.forward(req, resp);

        /* forward 방식 : 다른 서블릿으로 위임하면서 데이터 공유(req 를 통해)가 가능하다.
        * 클라이언트는 forward 사실을 알 필요가 없으므로 요청 url은 변경되지 않는다.
        * 새로고핌(=재요청) 시 동일 요청을 반복하게 되는데 이 떄 DB에 insert 등의 행위가 있으면
        * 중복 행 삽입이 되는 문제가 생긴다. -> 이런 경우는 redirect 방식 응답을 해야 한다.
        *  */
    }
}
