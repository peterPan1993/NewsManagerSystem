package com.bdqn.web.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * 监听器  (感知作用域对象里面属性的增删改)
 * 监听Session作用域的事件
 */
public class SessionAttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        httpSessionBindingEvent.getSession();
        httpSessionBindingEvent.getName();
        httpSessionBindingEvent.getValue();
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        httpSessionBindingEvent.getSession();
        httpSessionBindingEvent.getName();
        httpSessionBindingEvent.getValue();
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        httpSessionBindingEvent.getSession();
        httpSessionBindingEvent.getName();
        //替换方法中获得的是属性的旧值
        httpSessionBindingEvent.getValue();
    }
}
