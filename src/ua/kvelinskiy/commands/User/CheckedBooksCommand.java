package ua.kvelinskiy.commands.User;

import ua.kvelinskiy.commands.interfaces.Command;
import ua.kvelinskiy.commands.interfaces.IRequestWrapper;
import ua.kvelinskiy.dao.BookDAO;
import ua.kvelinskiy.dao.CatalogueDAO;
import ua.kvelinskiy.dao.FactoryDAO;
import ua.kvelinskiy.entities.Book;
import ua.kvelinskiy.entities.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public class CheckedBooksCommand implements Command {
    @Override
    public String execute(IRequestWrapper wrapper) {
        HttpSession session = wrapper.getSession(true);
        User user = (User) session.getAttribute("user");
        if (user == null){
            return "/index.jsp";
        }
        FactoryDAO factory = FactoryDAO.getInstance();
        CatalogueDAO catalogueDao = factory.getCatalogueDAO();
        String idUser = Integer.toString(user.getId());
        String[] idBooks = wrapper.getParameterValues("bookId");
        if(idBooks != null) {
            for (String idBook : idBooks) {
                catalogueDao.updateUserId(idBook, idUser);
            }
        }
        BookDAO bookDao = factory.getBooksDAO();
        List<Book> bookList = bookDao.showUserBooksList(user.getId());
        session.setAttribute("bookList", bookList);
        String path = "/userPages/bookCase.jsp";
        session.setAttribute("path", path);
        return path;
    }
}
