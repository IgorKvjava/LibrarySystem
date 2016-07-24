package ua.kvelinskiy.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class LogoutCommand implements Command {
    @Override
    public String execute(IRequestWrapper wrapper){
        HttpSession session = wrapper.getSession(true);
        session.invalidate();
        return "/index.jsp";
    }
}
