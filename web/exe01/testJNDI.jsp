<%@ page import="javax.naming.InitialContext,javax.naming.Context" %>
<%@ page import="com.bdqn.dao.UserDao" %>
<%@ page import="com.bdqn.dao.impl.UserDaoImpl" %>
<%@ page import="com.bdqn.entity.NewsUsers" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/16
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Context ct = new InitialContext();
    out.print(ct.lookup("java:comp/env/tjndi"));
    UserDao us = new UserDaoImpl();
    NewsUsers user = new NewsUsers();
    user.setUname("test1");
    user.setUpwd("123456");
    out.print(us.addUser(user));
%>
</body>
</html>
