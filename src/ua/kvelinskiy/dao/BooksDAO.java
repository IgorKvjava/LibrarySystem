package ua.kvelinskiy.dao;

import ua.kvelinskiy.entities.BooksUser;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class BooksDAO {
    private DataSource ds;
    // private static final Logger logger = Logger.getLogger(UsersDAO.class);
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("sqlstatements");

    public BooksDAO(DataSource ds) {
        this.ds = ds;
    }

    public List<BooksUser> showBooksList(int idGenre){
        List<BooksUser> booksList = new ArrayList<>();
        try (Connection conn = ds.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(resourceBundle.getString("GET_BOOKS_LIST"));
            ps.setString(1, String.valueOf(idGenre));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int numberPages = rs.getInt("number_pages");
                int  id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                Date publicationDate = rs.getDate("publication_date");
                String status = rs.getString("status");
                booksList.add(new BooksUser(id, numberPages, title, author, publisher, publicationDate, status));
            }
            return booksList;
        } catch (SQLException e) {
            //logger.error("SQL error, " + e);
            return null;
        }
    }
}
