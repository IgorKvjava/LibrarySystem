package ua.kvelinskiy.dao;

import org.apache.log4j.Logger;
import ua.kvelinskiy.entities.Catalogue;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class CatalogueDAO {
    private DataSource ds;
    private static final Logger LOGGER = Logger.getLogger(CatalogueDAO.class);
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("sqlstatements");

    public CatalogueDAO(DataSource ds) {
        this.ds = ds;
    }

    public boolean insertOrder(Catalogue catalogue) throws SQLException {
        try (Connection conn = ds.getConnection()) {
                PreparedStatement ps = conn.prepareStatement(resourceBundle.getString("INSERT_ORDER_CATALOGUE"));
                ps.setString(1, String.valueOf(catalogue.getIdUser()));
                ps.setString(2, String.valueOf(catalogue.getIdBook()));
                ps.setString(3, catalogue.getStatus());
                ps.setString(4, String.valueOf(catalogue.getDateIssue()));
                ps.setString(5, String.valueOf(catalogue.getDateReturn()));
                ps.execute();
            return true;
        } catch (SQLException e) {
            LOGGER.error("SQL error, " + e);
            return false;
        }
    }
//public class CheckedBooksCommand
    public boolean updateUserId(String idBook, String idUser) {
        try (Connection conn = ds.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(resourceBundle.getString("UPDATE_CATALOGUE_USER_ID"));
            ps.setString(1, idUser);
            ps.setString(2, idBook);
            ps.execute();
            return true;
        } catch (SQLException e) {
            LOGGER.error("SQL error, " + e);
            return false;
        }
    }

    public List<Catalogue> getCatalogueListBooks() {
        List<Catalogue> catalogueListBooks = new ArrayList<>();
        try (Connection conn = ds.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(resourceBundle.getString("GET_CATALOGUE_BOOKS"));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idUser = rs.getInt("id_user");
                String abonnement = rs.getString("abonnement");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                String status = rs.getString("status");
                String orderStatus = rs.getString("order_status");
                Date dateIssue = rs.getDate("date_issue");
                Date dateReturn = rs.getDate("date_return");
                catalogueListBooks.add(new Catalogue(idUser, abonnement, title, author, publisher, status, orderStatus, dateIssue, dateReturn));
            }
            return catalogueListBooks;
        } catch (SQLException e) {
            LOGGER.error("SQL error, " + e);
            return null;
        }
    }
//public class PlaceOrderCommand
    public boolean updateCatalogueStatus(String id, String status, int idUser, String dateIssue, String dateReturn) {
        try (Connection conn = ds.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(resourceBundle.getString("UPDATE_CATALOGUE_STATUS"));
            int idCatalogue = Integer.parseInt(id);
            ps.setString(1, status);
            ps.setString(2, status);
            ps.setInt(3, idUser);
            ps.setDate(4, java.sql.Date.valueOf(dateIssue));
            ps.setDate(5, java.sql.Date.valueOf(dateReturn));
            ps.setInt(6, idCatalogue);
            ps.execute();
            return true;
        } catch (SQLException e) {
            LOGGER.error("SQL error, " + e);
            return false;
        }

    }
}
