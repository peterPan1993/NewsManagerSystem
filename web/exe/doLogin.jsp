<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	request.setCharacterEncoding("utf-8");
	String userName=request.getParameter("userName");
	String password=request.getParameter("password");
	if("admin".equals(userName) && "admin".equals(password)){
		
		Cookie ckName = new Cookie("userName",userName);
		Cookie ckPassword = new Cookie("password",password);
		ckPassword.setMaxAge(30);
		
		response.addCookie(ckName);
		response.addCookie(ckPassword);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}else{
		response.sendRedirect("login.jsp");
	}
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'doLogin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
