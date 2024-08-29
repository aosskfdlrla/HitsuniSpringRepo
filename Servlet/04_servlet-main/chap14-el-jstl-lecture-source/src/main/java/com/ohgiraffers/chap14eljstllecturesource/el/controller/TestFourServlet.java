package com.ohgiraffers.chap14eljstllecturesource.el.controller;

import com.ohgiraffers.chap14eljstllecturesource.el.model.dto.MemberDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/test4")
public class TestFourServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MemberDTO sessionMember = new MemberDTO("홍길동", 19, "010-1234-5678", "gildong@ohgiraffers.com");
        MemberDTO requestMember = new MemberDTO("유관순", 16, "010-9876-5432", "yoo@ohgiraffers.com");

        HttpSession session = req.getSession();
        session.setAttribute("member", sessionMember);
        req.setAttribute("member", requestMember);

        RequestDispatcher rd = req.getRequestDispatcher("views/el/testEl4.jsp");
        rd.forward(req, resp);

    }
}
