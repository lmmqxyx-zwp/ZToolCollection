<%--
  Created by IntelliJ IDEA.
  User: byvai
  Date: 2017/10/4
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../taglib.jsp"%>
<html>
<head>
    <title>ZTC | 主页</title>
    <link rel="icon" href="${ctx}/ztcIcon.ico" type="image/x-icon" />
</head>
<body>
    ztcHomeIndex 前台主页

    <form action="/ztc/ztcApp/uploadImage.ztc" method="post" enctype="multipart/form-data">

        <input type="file" name="up">

        <button type="submit">文件上传</button>

    </form>
</body>
</html>
