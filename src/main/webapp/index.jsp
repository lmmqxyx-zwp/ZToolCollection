<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ZTC | 主页</title>
</head>
<body>
<%
    String path = request.getContextPath();
    response.sendRedirect(path+"/ztc/index.ztc");
%>
</body>
</html>