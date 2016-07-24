package ua.kvelinskiy.commands.User;

import ua.kvelinskiy.commands.Command;
import ua.kvelinskiy.commands.IRequestWrapper;
import ua.kvelinskiy.dao.BooksDAO;
import ua.kvelinskiy.dao.FactoryDAO;
import ua.kvelinskiy.entities.BooksUser;
import ua.kvelinskiy.entities.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
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
        FactoryDAO factory = FactoryDAO.getInstance();
        BooksDAO booksDao = factory.getBooksDAO();
        List<BooksUser> booksList = new ArrayList<>();
        int idGenre = Integer.parseInt(wrapper.getParameter("idGenre"));
        booksList.addAll(booksDao.showBooksList(idGenre));
        session.setAttribute("booksList", booksList);
        return "/userPages/userOrderBooks.jsp";
    }
}