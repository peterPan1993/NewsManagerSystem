<%@ page import="javax.naming.InitialContext,javax.naming.Context" %>
<%@ page import="com.bdqn.dao.UserDao" %>
<%@ page import="com.bdqn.dao.impl.UserDaoImpl" %>
<%@ page import="com.bdqn.entity.NewsUsers" %>
<%@ page import="com.bdqn.utils.DataSourceUtil" %><%--
  Created by IntelliJ IDEA.
  AbstractUser: Administrator
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
    //JNDI必须运行到Tomcat服务器测试，不能使用main/junit运行测试，否则报错
    Context ct = new InitialContext();
    out.print(ct.lookup("java:comp/env/tjndi"));
    UserDao us = new UserDaoImpl(DataSourceUtil.getConnectionJNDI());
    NewsUsers user = new NewsUsers();
    user.setUname("test1");
    user.setUpwd("123456");
    out.print(us.addUser(user));
%>
</body>
</html>
