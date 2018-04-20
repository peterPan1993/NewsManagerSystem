package com.bdqn.servlet;

import com.bdqn.entity.NewsUsers;
import com.bdqn.service.UserService;
import com.bdqn.service.impl.UserServiceImpl;
import com.bdqn.web.listener.OnlineUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = (String) req.getAttribute("userName");
        String password = (String) req.getAttribute("password");
        NewsUsers user = userService.login(userName,password);
        OnlineUser onlineUser = new OnlineUser();
        onlineUser.setUser(user);
        req.getSession().setAttribute("onlineUser", onlineUser);
        resp.sendRedirect("401.jsp");
    }
}
