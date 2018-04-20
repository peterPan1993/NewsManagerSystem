package com.bdqn.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        if (session!=null && session.getAttribute("name")!=null && session.getAttribute("name").toString().length()>0) {
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            ((HttpServletResponse) servletResponse).sendRedirect("401.html");
        }
    }

    @Override
    public void destroy() {

    }
}
