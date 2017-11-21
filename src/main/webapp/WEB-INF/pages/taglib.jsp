<%--
  author: zwp
  Date: 2017/11/12 22:56
  功能：引入JSP标签
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- webapp根目录 --%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%-- 静态资源 --%>
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/statics"/>
