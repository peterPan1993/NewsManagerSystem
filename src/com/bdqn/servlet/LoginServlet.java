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
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName").trim();
        String password = req.getParameter("password").trim();
        NewsUsers user = userService.login(userName,password);
        if (user != null){
            if (user.getUname() != null){
                req.getSession().setAttribute("user",user);
                OnlineUser onlineUser = new OnlineUser();
                onlineUser.setUser(user);
                req.getSession().setAttribute("onlineUser", onlineUser);
                resp.setContentType("text/html;charset=UTF-8");
                PrintWriter out = resp.getWriter();
                out.print(1);
                out.flush();
                out.close();
            } else {
                PrintWriter out = resp.getWriter();
                out.print(0);
                out.flush();
                out.close();
            }
        } else {
            PrintWriter out = resp.getWriter();
            out.print(-1);
            out.flush();
            out.close();
        }
    }
}
