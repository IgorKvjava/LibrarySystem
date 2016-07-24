package ua.kvelinskiy.commands;

import ua.kvelinskiy.dao.FactoryDAO;
import ua.kvelinskiy.dao.UsersDAO;
import ua.kvelinskiy.entities.Catalogue;
import ua.kvelinskiy.entities.Users;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class LoginCommand implements Command {
    //private static final Logger logger = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(IRequestWrapper wrapper) {
        HttpSession session = wrapper.getSession(true);
        String login = wrapper.getParameter("login");
        String password = wrapper.getParameter("password");
        Users user = new Users();
        user.setLogin(login);
        user.setPassword(password);
        FactoryDAO factory = FactoryDAO.getInstance();
        UsersDAO userDao = factory.getUsersDAO();
        boolean isExist = false;
        isExist = userDao.isExist(user);
        if (isExist) {
            userDao.getUserData(user);
            session.setAttribute("user", user);
            session.setAttribute("id", user.getId());
            session.setAttribute("firstName", user.getFirstName());
            session.setAttribute("lastName", user.getLastName());
            session.setAttribute("abonnement", user.getAbonnement());
            session.setAttribute("contactInformation", user.getContactInformation());
            session.setAttribute("login", user.getLogin());
            session.setAttribute("password", user.getPassword());
            if (user.getIsLibrarian()) {
                List<Users> usersList = new ArrayList<>();
                usersList.addAll(userDao.showActiveUsers());
                session.setAttribute("usersList", usersList);
                session.setAttribute("requestStatus", "choose");
                return "/librarianPages/mainLibrarianPage.jsp";
            } else {
                if (session.getAttribute("catalogueUser") == null) {
                    Catalogue catalogueUserNew = new Catalogue();
                    session.setAttribute("catalogueUserNew", catalogueUserNew);
                }
                return "userPages/mainUserPage.jsp";
            }
        } else {
            return "/errorPage.jsp";

        }
    }
}
