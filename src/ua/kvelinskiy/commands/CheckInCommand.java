package ua.kvelinskiy.commands;

import ua.kvelinskiy.dao.FactoryDAO;
import ua.kvelinskiy.dao.UsersDAO;
import ua.kvelinskiy.entities.Users;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;


public class CheckInCommand implements Command {

    @Override
    public String execute(IRequestWrapper wrapper) {
       String password = wrapper.getParameter("password");
        String login = wrapper.getParameter("login");
        Users user = new Users();
        user.setLogin(login);
        user.setPassword(password);
        FactoryDAO factory = FactoryDAO.getInstance();
        UsersDAO userDao = factory.getUsersDAO();
        if(userDao.insertNewUser(user)){
            return "/index.jsp";
        }else
        return "/password.jsp";
    }
}
