package com.ohgiraffers.chap14eljstllecturesource.el.controller;

import com.ohgiraffers.chap14eljstllecturesource.el.model.dto.MemberDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/test2")
public class TestTwoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MemberDTO member = new MemberDTO("홍길동", 19, "010-1234-5678", "gildong@ohgiraffers.com");
        req.setAttribute("member", member);

        RequestDispatcher rd = req.getRequestDispatcher("views/el/testEl2.jsp");
        rd.forward(req, resp);

    }
}
