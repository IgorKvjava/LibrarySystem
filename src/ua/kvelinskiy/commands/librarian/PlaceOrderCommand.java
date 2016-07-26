package ua.kvelinskiy.commands.librarian;

import ua.kvelinskiy.commands.interfaces.IRequestWrapper;
import ua.kvelinskiy.dao.CatalogueDAO;
import ua.kvelinskiy.dao.FactoryDAO;
import javax.servlet.http.HttpSession;

public class PlaceOrderCommand implements ua.kvelinskiy.commands.interfaces.Command {
    @Override
    public String execute(IRequestWrapper wrapper) {
        HttpSession session = wrapper.getSession(true);
        String[] idStatus = wrapper.getParameterValues("idStat");
        String[] idCatalogue = wrapper.getParameterValues("idCatal");
        FactoryDAO factory = FactoryDAO.getInstance();
        CatalogueDAO catalogueDao = factory.getCatalogueDAO();
        String [] staList = (String[]) session.getAttribute("staList");
        int clientId = (int) session.getAttribute("clientId");
        String listStatus;
        int idTime;
        if (idStatus != null) {
            lab1:for (int i = 0; i < idStatus.length; i++) {
                listStatus = staList[new Integer(idStatus[i])];
                idTime = clientId;
                if (listStatus.equals("Free")) {
                    idTime = 1;
                }
                if (listStatus.equals("Reserve")) {
                    continue lab1;
                }
                catalogueDao.updateCatalogueStatus(idCatalogue[i], listStatus, idTime);
            }
        }
        String path = "/librarianPages/mainLibrarianPage.jsp";
        session.setAttribute("path", path);
        return path;
    }
}
