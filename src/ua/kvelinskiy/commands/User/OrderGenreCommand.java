package ua.kvelinskiy.commands.User;

import ua.kvelinskiy.commands.Command;
import ua.kvelinskiy.commands.IRequestWrapper;
import ua.kvelinskiy.dao.FactoryDAO;
import ua.kvelinskiy.dao.GenresDAO;
import ua.kvelinskiy.entities.Genres;
import ua.kvelinskiy.entities.Users;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderGenreCommand implements Command {
    @Override
    public String execute(IRequestWrapper wrapper) {
        HttpSession session = wrapper.getSession(true);
        Users user = (Users) session.getAttribute("user");
        if (user == null){
            return "/index.jsp";
        }
        FactoryDAO factory = FactoryDAO.getInstance();
        GenresDAO genresDao = factory.getGenresDAO();
        List<Genres> genresList = new ArrayList<>();
        genresList.addAll(genresDao.showGenresList());
        session.setAttribute("genresList", genresList);
        return "/userPages/userOrderPage.jsp";
    }
}
