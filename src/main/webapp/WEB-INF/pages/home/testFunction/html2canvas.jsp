<%--
  Created by IntelliJ IDEA.
  User: byvai
  Date: 2017/11/7
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--测试静态资源加载--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/statics"/>
<html>
<head>
    <title>ztc小功能 | html2canvas</title>
    <script type="text/javascript" src="${ctxStatic}/html2canvas.js"></script>
    <script type="text/javascript" src="${ctxStatic}/jquery.js"></script>
</head>
<body>

<h1>html2canvas</h1>

<body>
<div id="view" style="background:url('${ctxStatic}/jssite.png') 50%; width: 700px; height: 500px;">
    <input type="button" value="截图" onclick="takeScreenshot()">
</div>
</body>

<script type="application/javascript">
    function takeScreenshot() {
        console.log('test');
        html2canvas(document.getElementById('view'), {
            onrendered: function (canvas) {
                //document.body.appendChild(canvas);
                var ctxImage = canvas.toDataURL("image/png");
                console.log(ctxImage);
                //并将图片上传到服务器
                var url = "/ztc/testFunction/ctxImage.ztc";
                $.ajax({
                    type: "POST",
                    url: url,
                    data: {data: ctxImage},
                    timeout: 60000,
                    success: function (data) {
                        console.log(data);
                        //$('#myShowImage').attr('src', '${ctxStatic}/usertemp/'+data+'.jpg'); //服务器上保存图片路径，data是返回的文件名。
                    }
                });
            },
            // width: 300,
            // height: 300
        });
    }
</script>
</body>
</html>
