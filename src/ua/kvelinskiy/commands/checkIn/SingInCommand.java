package ua.kvelinskiy.commands.checkIn;

import ua.kvelinskiy.commands.interfaces.Command;
import ua.kvelinskiy.commands.interfaces.IRequestWrapper;
import ua.kvelinskiy.dao.FactoryDAO;
import ua.kvelinskiy.dao.UsersDAO;
import ua.kvelinskiy.entities.Users;
import javax.servlet.http.HttpSession;

public class SingInCommand implements Command {
    @Override
    public String execute(IRequestWrapper wrapper) {
        HttpSession session = wrapper.getSession(true);
        String login = wrapper.getParameter("login");
        session.setAttribute("login", login);
        Users user = new Users();
        user.setLogin(login);
        session.setAttribute("user", user);
        FactoryDAO factory = FactoryDAO.getInstance();
        UsersDAO userDao = factory.getUsersDAO();
        boolean isExist = userDao.isExistLogin(user);
        if (isExist) {
            session.setAttribute("login_used", "LoginUsed");
            String path = "/registration.jsp";
            session.setAttribute("path", path);
            return path;
        } else {
            session.setAttribute("incorrectLogin", true);
            String path = "/password.jsp";
            session.setAttribute("path", path);
            return path;
        }
    }
}
