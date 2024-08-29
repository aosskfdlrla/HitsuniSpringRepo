<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <!-- include 지시자 태그는 해당 jsp에 작성 된 내용을 그대로 포함 시켜 현재 jsp 파일을 동작시킨다. -->
    <div>
        <%@ include file="today.jsp"%>
    </div>

    <!-- include 된 jsp 파일과 동일한 변수명을 사용하려고 하면 컴파일 에러가 발생한다. -->
    <%
//        String output = "";
    %>

</body>
</html>
