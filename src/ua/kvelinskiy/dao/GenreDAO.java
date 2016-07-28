package ua.kvelinskiy.dao;

import ua.kvelinskiy.entities.Genre;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class GenreDAO {
    private DataSource ds;
    // private static final Logger logger = Logger.getLogger(UserDAO.class);
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("sqlstatements");

    public GenreDAO(DataSource ds) {
        this.ds = ds;
    }

    public Genre getGenreData(Genre genre){
        try (Connection conn = ds.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(resourceBundle.getString("GET_GENRE_DATA"));
            ps.setString(1, genre.getGenre());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                genre.setId(rs.getInt("id"));
                genre.setGenre(rs.getString("genre"));
            }
            return genre;
        } catch (SQLException e) {
            //logger.error("SQL error, " + e);
            return null;
        }
    }

    public List<Genre> showGenresList(){
        List<Genre> genreList = new ArrayList<>();
        try (Connection conn = ds.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(resourceBundle.getString("GET_GENRE_LIST"));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String 	genre = rs.getString("genre");
                genreList.add(new Genre(id, genre));
            }
            return genreList;
        } catch (SQLException e) {
            //logger.error("SQL error, " + e);
            return null;
        }
    }


}
