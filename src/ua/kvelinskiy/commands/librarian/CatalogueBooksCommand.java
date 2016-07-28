package ua.kvelinskiy.commands.librarian;

import ua.kvelinskiy.commands.interfaces.Command;
import ua.kvelinskiy.commands.interfaces.IRequestWrapper;
import ua.kvelinskiy.dao.CatalogueDAO;
import ua.kvelinskiy.dao.FactoryDAO;
import ua.kvelinskiy.entities.Catalogue;
import ua.kvelinskiy.entities.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public class CatalogueBooksCommand implements Command {
    @Override
    public String execute(IRequestWrapper wrapper) {
        HttpSession session = wrapper.getSession(true);
        User user = (User) session.getAttribute("user");
        if (user == null) {
            session.invalidate();
            return "/index.jsp";
        }
        FactoryDAO factory = FactoryDAO.getInstance();
        CatalogueDAO catalogueDao = factory.getCatalogueDAO();
        List<Catalogue> catalogueBooks = catalogueDao.getCatalogueListBooks();
        session.setAttribute("catalogueBooks", catalogueBooks);
        String path = "/librarianPages/catalogueBooks.jsp";
        session.setAttribute("path", path);
        return path;
    }
}
