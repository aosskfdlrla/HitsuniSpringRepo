package com.ohgiraffers.chap05.section02.headers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet("/headers")
public class ResponseHeaderPrintServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
//        resp.setHeader("Refresh", "1");

        PrintWriter writer = resp.getWriter();
        long currentTime = System.currentTimeMillis();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>")
                .append("<head>")
                .append("<title>응답 페이지</title>")
                .append("</head>")
                .append("<body>")
                .append("<h1>")
                .append(currentTime)
                .append("</h1>")
                .append("</body>")
                .append("</html>");

        writer.print(stringBuilder);
        writer.flush();
        writer.close();

        /* response header 정보 */
        Collection<String> responseHeaders = resp.getHeaderNames();
        for (String headerName : responseHeaders) {
            System.out.println(headerName + " : " + resp.getHeader(headerName));
        }

    }
}
