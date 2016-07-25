package ua.kvelinskiy.commands.librarian;

import ua.kvelinskiy.commands.interfaces.Command;
import ua.kvelinskiy.commands.interfaces.IRequestWrapper;
import ua.kvelinskiy.entities.Users;

import javax.servlet.http.HttpSession;

public class ListClientsCommand implements Command {
    @Override
    public String execute(IRequestWrapper wrapper) {
        HttpSession session = wrapper.getSession(true);
        Users user = (Users) session.getAttribute("user");
        if (user == null){
            session.invalidate();
            return "/index.jsp";
        }
        String path = "/librarianPages/listClients.jsp";
        session.setAttribute("path", path);
        return path;
    }
}
