package ua.kvelinskiy.commands.User;

import ua.kvelinskiy.commands.interfaces.Command;
import ua.kvelinskiy.commands.interfaces.IRequestWrapper;
import ua.kvelinskiy.dao.CatalogueDAO;
import ua.kvelinskiy.dao.FactoryDAO;
import ua.kvelinskiy.entities.Catalogue;
import ua.kvelinskiy.entities.Users;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class CheckedBooksCommand implements Command {
    @Override
    public String execute(IRequestWrapper wrapper) {
        HttpSession session = wrapper.getSession(true);
        Users user = (Users) session.getAttribute("user");
        if (user == null){
            return "/index.jsp";
        }
        String path;
        FactoryDAO factory = FactoryDAO.getInstance();
        CatalogueDAO catalogueDao = factory.getCatalogueDAO();
        String idUser = Integer.toString(user.getId());
        String[] idBooks = wrapper.getParameterValues("bookId");
        List<Catalogue> catalogueList = new ArrayList<>();
        if(idBooks != null) {
            for (String idBook : idBooks) {
                catalogueDao.updateUserId(idBook, idUser);
            }
        }
        catalogueList.addAll(catalogueDao.getCatalogueListUser(idUser));
        session.setAttribute("catalogueList", catalogueList);
        path = "/userPages/bookCase.jsp";
        session.setAttribute("path", path);
        return path;
    }
}
