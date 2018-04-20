package com.bdqn.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 对页面字符编码的过滤器，默认UTF-8
 * @author Administrator
 */
public class CharacterEncodingFilter implements Filter {

    private String encoding;

    public String getEncoding() {
        return encoding;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String initParameter=filterConfig.getInitParameter("charset");
        this.encoding=((initParameter != null && (initParameter=initParameter.trim()).length()>0)?initParameter:"UTF-8");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(encoding);
        servletResponse.setCharacterEncoding(encoding);
        servletResponse.setContentType("text/html");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
