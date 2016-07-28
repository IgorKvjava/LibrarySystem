package ua.kvelinskiy.commands.librarian;

import ua.kvelinskiy.commands.interfaces.Command;
import ua.kvelinskiy.commands.interfaces.IRequestWrapper;
import ua.kvelinskiy.dao.BookDAO;
import ua.kvelinskiy.dao.FactoryDAO;
import ua.kvelinskiy.entities.Book;
import ua.kvelinskiy.entities.User;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class ClientSearchCommand implements Command {
    @Override
    public String execute(IRequestWrapper wrapper) {
        HttpSession session = wrapper.getSession(true);
        User user = (User) session.getAttribute("user");
        if (user == null) {
            session.invalidate();
            return "/index.jsp";
        }
        String subscription = wrapper.getParameter("abonnement");
        List<User> usersList = (List<User>) session.getAttribute("usersList");
        boolean searchUser = false;
        User u = null;
        for (User userLib : usersList) {
            if (userLib.getAbonnement().equals(subscription)) {
                u = userLib;
                session.setAttribute("client", userLib);
                searchUser = true;
            }
        }
        if (searchUser) {
            List<Book> bookUserList = new ArrayList<>();
            List<BookStatus> statusList = new ArrayList<>();
            String [] staList ={"Reserve", "Free", "BeUsed","ReferenceRoom"};
            session.setAttribute("staList", staList);
            for (int i = 0; i < 4 ; i++) {
                statusList.add(new BookStatus(staList[i],(i)));
            }
            FactoryDAO factory = FactoryDAO.getInstance();
            BookDAO bookDao = factory.getBooksDAO();
            bookUserList.addAll(bookDao.showUserBooksList(u.getId()));
            session.setAttribute("clientId", u.getId());
            session.setAttribute("bookUserList", bookUserList);
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
            private String status;
            private int idStatus;
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
