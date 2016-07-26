package ua.kvelinskiy.commands.User;

import ua.kvelinskiy.commands.interfaces.Command;
import ua.kvelinskiy.commands.interfaces.IRequestWrapper;
import ua.kvelinskiy.dao.BooksDAO;
import ua.kvelinskiy.dao.FactoryDAO;
import ua.kvelinskiy.entities.Books;
import ua.kvelinskiy.entities.Users;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class OrderBooksCommand implements Command {
    @Override
    public String execute(IRequestWrapper wrapper) {
        HttpSession session = wrapper.getSession(true);
        Users user = (Users) session.getAttribute("user");
        if (user == null){
            return "/index.jsp";
        }
        String path;
        FactoryDAO factory = FactoryDAO.getInstance();
        BooksDAO booksDao = factory.getBooksDAO();
        List<Books> booksList = new ArrayList<>();
        int idGenre = Integer.parseInt(wrapper.getParameter("idGenre"));
        booksList.addAll(booksDao.showBooksList(idGenre));
        session.setAttribute("booksList", booksList);
        path = "/userPages/userOrderBooks.jsp";
        session.setAttribute("path", path);
        return path;
    }
}
