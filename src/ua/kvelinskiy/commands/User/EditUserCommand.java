package ua.kvelinskiy.commands.User;

import ua.kvelinskiy.commands.Command;
import ua.kvelinskiy.commands.IRequestWrapper;
import ua.kvelinskiy.dao.FactoryDAO;
import ua.kvelinskiy.dao.UsersDAO;
import ua.kvelinskiy.entities.Users;

import javax.servlet.http.HttpSession;

public class EditUserCommand implements Command {
    @Override
    public String execute(IRequestWrapper wrapper) {
        HttpSession session = wrapper.getSession(true);
        Users user = (Users) session.getAttribute("user");
        if (user == null) {
            return "/index.jsp";
        }
        FactoryDAO factory = FactoryDAO.getInstance();
        UsersDAO userDao = factory.getUsersDAO();
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
            return "mainUserPage.jsp";
        }
        return "userEditDataPage.jsp";
    }
}
