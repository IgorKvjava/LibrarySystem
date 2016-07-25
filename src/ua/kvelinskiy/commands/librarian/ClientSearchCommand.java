package ua.kvelinskiy.commands.librarian;

import ua.kvelinskiy.commands.interfaces.Command;
import ua.kvelinskiy.commands.interfaces.IRequestWrapper;
import ua.kvelinskiy.dao.BooksDAO;
import ua.kvelinskiy.dao.FactoryDAO;
import ua.kvelinskiy.entities.Books;
import ua.kvelinskiy.entities.Users;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
        Users u = null;
        for (Users userLib : usersList) {
            if (userLib.getAbonnement().equals(subscription)) {
                u = userLib;
                session.setAttribute("client", userLib);
                searchUser = true;
            }
        }
        if (searchUser) {
            List<Books> booksUserList = new ArrayList<>();
            List<BookStatus> statusList = new ArrayList<>();
            String [] staList ={"Reserve", "Free", "BeUsed","ReferenceRoom"};
            for (int i = 0; i < 4 ; i++) {
                statusList.add(new BookStatus(staList[i],(i+1)));
            }
            FactoryDAO factory = FactoryDAO.getInstance();
            BooksDAO booksDao = factory.getBooksDAO();
            booksUserList.addAll(booksDao.showUserBooksList(u.getId()));
            session.setAttribute("booksUserList", booksUserList);
            session.setAttribute("statusList", statusList);
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

        public class BookStatus {
            public String status;
            public int idStatus;
            public BookStatus(String status, int idStatus) {
                this.status = status;
                this.idStatus = idStatus;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public int getIdStatus() {
                return idStatus;
            }

            public void setIdStatus(int idStatus) {
                this.idStatus = idStatus;
            }
        }

}
