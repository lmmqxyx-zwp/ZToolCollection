<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ZTC | 主页</title>
</head>
<body>
<%-- 用来定位到pages下面 --%>

<c:set var="ctxStatic" value="${pageContext.request.contextPath}/statics"/>
<%
    String path = request.getContextPath();
    response.sendRedirect(path+"/ztc/index.ztc");
%>
</body>
</html>