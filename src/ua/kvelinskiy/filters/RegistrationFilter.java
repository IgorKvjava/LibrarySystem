package ua.kvelinskiy.filters;

import javax.servlet.*;
import java.io.IOException;

public class RegistrationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse
            , FilterChain filterChain) throws IOException, ServletException {
        String name = servletRequest.getParameter("login");
        String pass = servletRequest.getParameter("password");
        if (name == null || pass == null){
           servletRequest.setAttribute("incorrect",true);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
