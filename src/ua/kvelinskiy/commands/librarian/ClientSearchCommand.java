package ua.kvelinskiy.commands.librarian;

import ua.kvelinskiy.commands.interfaces.Command;
import ua.kvelinskiy.commands.interfaces.IRequestWrapper;
import ua.kvelinskiy.dao.BooksDAO;
import ua.kvelinskiy.dao.CatalogueDAO;
import ua.kvelinskiy.dao.FactoryDAO;
import ua.kvelinskiy.entities.Users;

import javax.servlet.http.HttpSession;
import java.util.List;

public class ClientSearchCommand implements Command {
    @Override
    public String execute(IRequestWrapper wrapper) {
        HttpSession session = wrapper.getSession(true);
        Users user = (Users) session.getAttribute("user");
        if (user == null) {
            session.invalidate();
            return "/index.jsp";
        }
        String subscription = wrapper.getParameter("abonnement");
        List<Users> usersList = (List<Users>) session.getAttribute("usersList");
        boolean searchUser = false;
        for (Users userLib : usersList) {
            if (userLib.getAbonnement().equals(subscription)) {
                session.setAttribute("client", userLib);
                searchUser = true;
            }
        }
        if (searchUser) {
            FactoryDAO factory = FactoryDAO.getInstance();
            BooksDAO booksDAO = factory.getBooksDAO();


            session.setAttribute("requestStatus", "Choose");
            String path = "/librarianPages/clientSearch.jsp";
            session.setAttribute("path", path);
            return path;
        }
        session.setAttribute("requestStatus", "Fail");
        String path = "/librarianPages/mainLibrarianPage.jsp";
        session.setAttribute("path", path);
        return path;
    }
}
