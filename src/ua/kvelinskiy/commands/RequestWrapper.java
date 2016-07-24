package ua.kvelinskiy.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class RequestWrapper implements IRequestWrapper {
    private HttpServletRequest request;
    String [] strings;

    public RequestWrapper(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public String getParameter(String key) {
        return request.getParameter(key);
    }

    @Override
    public HttpSession getSession(Boolean flag) {
        return request.getSession(flag);
    }

    @Override
    public String[] getParameterValues(String s) {
        strings = request.getParameterValues(s);
        return strings;
    }
}
