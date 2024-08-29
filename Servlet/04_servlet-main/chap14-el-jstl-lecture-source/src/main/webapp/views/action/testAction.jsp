<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Action Tag</title>
</head>
<body>
<!-- JSP 액션 태그는 여는 태그 뒤에 닫는 태그를 반드시 작성해야 한다.
작성하지 않으면 500 에러가 발생한다. -->
<jsp:include page="common.jsp"/>

<h1>여기서부터 내용입니다.</h1>

<% request.setAttribute("name", "홍길동"); %>

<jsp:forward page="testForward.jsp"/>
</body>
</html>
