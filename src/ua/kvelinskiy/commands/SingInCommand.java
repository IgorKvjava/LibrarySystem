package ua.kvelinskiy.commands;

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
        FactoryDAO factory = FactoryDAO.getInstance();
        UsersDAO userDao = factory.getUsersDAO();
        boolean isExist = userDao.isExistLogin(user);
        if (isExist) {
            session.setAttribute("login_used", "login used");
            return "/registration.jsp";
        } else {
            session.setAttribute("incorrectLogin", true);
            return "/password.jsp";
        }
    }
}