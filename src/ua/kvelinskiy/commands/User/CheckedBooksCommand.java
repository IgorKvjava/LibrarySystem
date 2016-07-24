package ua.kvelinskiy.commands.User;

import ua.kvelinskiy.commands.Command;
import ua.kvelinskiy.commands.IRequestWrapper;
import ua.kvelinskiy.dao.CatalogueDAO;
import ua.kvelinskiy.dao.FactoryDAO;
import ua.kvelinskiy.entities.Catalogue;
import ua.kvelinskiy.entities.Users;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
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
        return "/userPages/bookCase.jsp";
    }
}
