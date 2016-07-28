package ua.kvelinskiy.commands.User;

import ua.kvelinskiy.commands.interfaces.Command;
import ua.kvelinskiy.commands.interfaces.IRequestWrapper;
import ua.kvelinskiy.dao.BookDAO;
import ua.kvelinskiy.dao.FactoryDAO;
import ua.kvelinskiy.entities.Book;
import ua.kvelinskiy.entities.User;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class OrderBooksCommand implements Command {
    @Override
    public String execute(IRequestWrapper wrapper) {
        HttpSession session = wrapper.getSession(true);
        User user = (User) session.getAttribute("user");
        if (user == null){
            return "/index.jsp";
        }
        String path;
        FactoryDAO factory = FactoryDAO.getInstance();
        BookDAO bookDao = factory.getBooksDAO();
        List<Book> bookList = new ArrayList<>();
        int idGenre = Integer.parseInt(wrapper.getParameter("idGenre"));
        bookList.addAll(bookDao.showBooksList(idGenre));
        session.setAttribute("bookList", bookList);
        path = "/userPages/userOrderBooks.jsp";
        session.setAttribute("path", path);
        return path;
    }
}
