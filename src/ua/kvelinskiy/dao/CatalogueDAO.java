package ua.kvelinskiy.dao;

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
    // private static final Logger logger = Logger.getLogger(UsersDAO.class);
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
            // logger.error("SQL error, " + e);
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
            // logger.error("SQL error, " + e);
            return false;
        }
    }

    public List<Catalogue> getCatalogueListUser1(String idU) {
        List<Catalogue> catalogueList = new ArrayList<>();
        try (Connection conn = ds.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(resourceBundle.getString("GET_USER_CATALOGUE"));
            ps.setString(1, idU);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int idBook = rs.getInt("id_book");
                int idUser = rs.getInt("id_user");
                String status = rs.getString("status");
                String orderStatus = rs.getString("order_status");
                Date dateIssue = rs.getDate("date_issue");
                Date dateReturn = rs.getDate("date_return");
                catalogueList.add(new Catalogue(id, idBook, idUser, status, orderStatus, dateIssue, dateReturn));
            }
            return catalogueList;
        } catch (SQLException e) {
            //logger.error("SQL error, " + e);
            return null;
        }
    }
//public class PlaceOrderCommand
    public boolean updateCatalogueStatus(String id, String status, int idUser) {
        try (Connection conn = ds.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(resourceBundle.getString("UPDATE_CATALOGUE_STATUS"));
            int idCatalogue = Integer.parseInt(id);
            ps.setString(1, status);
            ps.setString(2, status);
            ps.setInt(3, idUser);
            ps.setInt(4, idCatalogue);
            ps.execute();
            return true;
        } catch (SQLException e) {
            // logger.error("SQL error, " + e);
            return false;
        }

    }
}
