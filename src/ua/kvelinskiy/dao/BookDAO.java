package ua.kvelinskiy.dao;

import org.apache.log4j.Logger;
import ua.kvelinskiy.entities.Book;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class BookDAO {
    private DataSource ds;
    private static final Logger LOGGER = Logger.getLogger(BookDAO.class);
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("sqlstatements");

    public BookDAO(DataSource ds) {
        this.ds = ds;
    }
//public class OrderBooksCommand
    public List<Book> showBooksList(int idGenre){
        List<Book> bookList = new ArrayList<>();
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
                Date dateIssue = rs.getDate("date_issue");
                Date dateReturn = rs.getDate("date_return");
                String status = rs.getString("status");
                String orderStatus = rs.getString("order_status");
                bookList.add(new Book(id, numberPages, title, author, publisher,
                        publicationDate, dateIssue, dateReturn, status, orderStatus));
            }
            return bookList;
        } catch (SQLException e) {
            LOGGER.error("SQL error, " + e);
            return null;
        }
    }

    public List<Book> showUserBooksList(int idUser){
        List<Book> bookList = new ArrayList<>();
        try (Connection conn = ds.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(resourceBundle.getString("GET_USER_BOOKS"));
            ps.setString(1, String.valueOf(idUser));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                Date dateIssue = rs.getDate("date_issue");
                Date dateReturn = rs.getDate("date_return");
                String statuss = rs.getString("status");
                String orderStatuss = rs.getString("order_status");
                int idCatalogue = rs.getInt("id");
                bookList.add(new Book(title, author, dateIssue, dateReturn, statuss, orderStatuss,idCatalogue));
            }
            return bookList;
        } catch (SQLException e) {
            LOGGER.error("SQL error, " + e);
            return null;
        }
    }
}
