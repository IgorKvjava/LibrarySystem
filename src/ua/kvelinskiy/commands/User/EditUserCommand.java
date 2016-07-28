package ua.kvelinskiy.commands.User;

import ua.kvelinskiy.commands.interfaces.Command;
import ua.kvelinskiy.commands.interfaces.IRequestWrapper;
import ua.kvelinskiy.dao.FactoryDAO;
import ua.kvelinskiy.dao.UserDAO;
import ua.kvelinskiy.entities.User;

import javax.servlet.http.HttpSession;

public class EditUserCommand implements Command {
    @Override
    public String execute(IRequestWrapper wrapper) {
        HttpSession session = wrapper.getSession(true);
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "/index.jsp";
        }
        String path;
        FactoryDAO factory = FactoryDAO.getInstance();
        UserDAO userDao = factory.getUsersDAO();
        user.setFirstName(wrapper.getParameter("first_name"));
        user.setLastName(wrapper.getParameter("last_name"));
        user.setContactInformation(wrapper.getParameter("contact_information"));
        user.setPassword(wrapper.getParameter("password"));
        session.setAttribute("user", user);
        session.setAttribute("firstName", user.getFirstName());
        session.setAttribute("lastName", user.getLastName());
        session.setAttribute("contactInformation", user.getContactInformation());
        session.setAttribute("password", user.getPassword());
        if (userDao.update(user)) {
        path = "/userPages/mainUserPage.jsp";
        session.setAttribute("path", path);
        return path;
        }
        path = "/userPages/userEditDataPage.jsp";
        session.setAttribute("path", path);
        return path;
    }
}
