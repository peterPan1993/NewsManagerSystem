package com.bdqn.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 监听器  (感知作用域对象创建及销毁)
 * 初始化数据资源
 * servletContext=application?
 */
public class GlobalResourcesInitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext application = servletContextEvent.getServletContext();

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
