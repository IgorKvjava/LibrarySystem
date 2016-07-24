package ua.kvelinskiy.filters;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by saha on 22.07.2016.
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        String login = servletRequest.getParameter("login");
        if (login == null){
            servletRequest.setAttribute("incorrectLogin",true);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
