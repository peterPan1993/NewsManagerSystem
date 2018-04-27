package com.bdqn.web.listener;

import com.bdqn.entity.NewsUsers;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.util.ArrayList;
import java.util.List;

public class OnlineUser implements HttpSessionBindingListener {

    private NewsUsers user = null;

    public NewsUsers getUser() {
        return user;
    }

    public void setUser(NewsUsers user) {
        this.user = user;
    }

    /**
     * 在session作用域设置本对象，自动运行该方法
     * @param httpSessionBindingEvent
     */
    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        ServletContext application = httpSessionBindingEvent.getSession().getServletContext();
        List<NewsUsers> userList = (List<NewsUsers>) application.getAttribute("ONLINE_USERS");
        if (userList == null ){
            userList = new ArrayList();
        }
        userList.add(user);
        application.setAttribute("ONLINE_USERS",userList);
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        ServletContext application = httpSessionBindingEvent.getSession().getServletContext();
        List<NewsUsers> userList = (List<NewsUsers>) application.getAttribute("ONLINE_USERS");
        if (userList != null ){
            userList.remove(user);
        }
        application.setAttribute("ONLINE_USERS",userList);
    }
}
