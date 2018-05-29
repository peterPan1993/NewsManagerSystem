package com.bdqn.servlet;

import com.bdqn.entity.NewsUsers;
import com.bdqn.service.UserService;
import com.bdqn.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName").trim();
        String password = req.getParameter("password").trim();
        NewsUsers user = new NewsUsers();
        user.setUname(userName);
        user.setUpwd(password);
        Integer result = userService.register(user);
        if (result != null && result > 0){
            resp.sendRedirect("index.jsp");
        }
        return;
    }
}
