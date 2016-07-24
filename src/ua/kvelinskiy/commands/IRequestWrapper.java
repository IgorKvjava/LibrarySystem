package ua.kvelinskiy.commands;

import javax.servlet.http.HttpSession;
import java.util.Objects;

public interface IRequestWrapper {
    public String getParameter(String key);
    public HttpSession getSession(Boolean flag);
    public String[] getParameterValues(String bookId);
}
