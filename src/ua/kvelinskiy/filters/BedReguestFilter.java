package ua.kvelinskiy.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by saha on 22.07.2016.
 */
public class BedReguestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String path = ((HttpServletRequest) servletRequest).getRequestURI();
        if (path.equals("/registration.jsp")){
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            //String contexpath=((HttpServletResponse) servletResponse).sendRedirect("/error.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
