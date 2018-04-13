<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/12
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Title</title>
</head>


<body>
<%!
    boolean findYear(int year) {
        if(year%4==0 && year%100!=0 ||year%400==0){
            return true;
        }else{
            return false;
        }
    }
%>
<%
    int count=0;
    for(int year=2000;year<=2013;year++){
        if(findYear(year)){
            count++;
        }
    }
%>
<%="计算2000年~2013年间，有"+count+"个闰年" %><br/>
<%
    int sum=0;
    for (int i = 2; i <= 100; i++) {
        boolean flag=true;
        for (int j = 2; j < i; j++) {
            if (i%j==0) {
                flag=false;
                break;
            }
        }
        if (flag) {
            sum+=i;
        }
    }
%>
<%="1~100之间的素数和为："+sum %><br/>
<!--<%=path+"+++"+basePath%>-->
<form action="<%=path%>/registerInfo.jsp" method="post">
    <table>
        <caption>请输入登录信息</caption>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td>checkBox</td>
            <td>
                <input type="checkbox" name="hobby" value="ball"/>球
                <input type="checkbox" name="hobby" value="run"/>跑
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" /></td>
        </tr>
    </table>
</form>
</body>
</html>
