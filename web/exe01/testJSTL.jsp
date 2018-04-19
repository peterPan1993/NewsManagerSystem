<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/19
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <title>Title</title>
</head>
<body>
    <!--测试jstl 通用标签-->
    设置变量之前的值是：msg=<c:out value="${msg}" default="null"/><br/>
    給变量设置......<c:set var="msg" value="Hello World!" scope="page"/><br/>
    设置新值以后：msg=<c:out value="${msg}" default="null"/><br/>
    把变量移除......<c:remove var="msg" scope="page"/><br/>
    移除变量msg以后：msg=<c:out value="${msg}" default="null"/><br/>
</body>
</html>
