package ua.kvelinskiy.commands;

import ua.kvelinskiy.commands.interfaces.Command;
import ua.kvelinskiy.commands.interfaces.IRequestWrapper;

import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {
    @Override
    public String execute(IRequestWrapper wrapper){
        HttpSession session = wrapper.getSession(true);
        String path = "/index.jsp";
        session.setAttribute("path", path);
        session.invalidate();
        return path;
    }
}
