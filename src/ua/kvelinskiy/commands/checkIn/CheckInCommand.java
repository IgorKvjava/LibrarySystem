package ua.kvelinskiy.commands.checkIn;

import ua.kvelinskiy.commands.interfaces.Command;
import ua.kvelinskiy.commands.interfaces.IRequestWrapper;
import ua.kvelinskiy.dao.FactoryDAO;
import ua.kvelinskiy.dao.UserDAO;
import ua.kvelinskiy.entities.User;

import javax.servlet.http.HttpSession;


public class CheckInCommand implements Command {

    @Override
    public String execute(IRequestWrapper wrapper) {
        HttpSession session = wrapper.getSession(true);
        String password = wrapper.getParameter("password");
        User user = (User) session.getAttribute("user");
        user.setPassword(password);
        FactoryDAO factory = FactoryDAO.getInstance();
        UserDAO userDao = factory.getUsersDAO();
        if (userDao.insertNewUser(user)) {
            String path = "/index.jsp";
            session.setAttribute("path", path);
            session.invalidate();
            return path;
        } else {
            String path = "/password.jsp";
            session.setAttribute("path", path);
            return path;
        }
    }
}
