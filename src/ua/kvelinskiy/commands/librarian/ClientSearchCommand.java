package ua.kvelinskiy.commands.librarian;

import ua.kvelinskiy.commands.Command;
import ua.kvelinskiy.commands.IRequestWrapper;
import ua.kvelinskiy.entities.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class ClientSearchCommand implements Command {
    @Override
    public String execute(IRequestWrapper wrapper) {
        HttpSession session = wrapper.getSession(true);
        Users user = (Users) session.getAttribute("user");
        if (user == null){
            return "/index.jsp";
        }
        String subscription = wrapper.getParameter("abonnement");
        List<Users> usersList = (List<Users>) session.getAttribute("usersList");
        boolean searchUser = false;
        for (Users userLib: usersList) {
            if (userLib.getAbonnement().equals(subscription)){
                session.setAttribute("client", userLib);
                searchUser =true;
            }
        }
        if (searchUser){
            session.setAttribute("requestStatus", "choose");
            return "/librarianPages/clientSearch.jsp";
        }
        session.setAttribute("requestStatus", "client subscription fail");
        return "/librarianPages/mainLibrarianPage.jsp";

    }
}
