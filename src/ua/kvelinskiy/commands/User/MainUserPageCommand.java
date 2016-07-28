package ua.kvelinskiy.commands.User;

import ua.kvelinskiy.commands.interfaces.IRequestWrapper;
import ua.kvelinskiy.commands.interfaces.Command;

import javax.servlet.http.HttpSession;

/**
 * Created by ihor on 24.07.16.
 */
public class MainUserPageCommand implements Command {
    @Override
    public String execute(IRequestWrapper wrapper) {
        HttpSession session = wrapper.getSession(true);
        String path = "userPages/mainUserPage.jsp";
        session.setAttribute("path", path);
        return path;

    }
}
