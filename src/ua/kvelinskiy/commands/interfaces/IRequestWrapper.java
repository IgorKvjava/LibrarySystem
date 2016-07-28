package ua.kvelinskiy.commands.interfaces;

import javax.servlet.http.HttpSession;

public interface IRequestWrapper {
    String getParameter(String key);
    HttpSession getSession(Boolean flag);
    String[] getParameterValues(String bookId);
    void setAttributes(String key, Object value);
    Object getAttributes(String name);
    /*public void extractParamValues();
    public String findParameterByName(String name);
    public void insertsAttributes();*/
}
