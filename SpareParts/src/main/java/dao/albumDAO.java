

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.album;

public class albumDAO {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/computer_spare_part?useSSL=false";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "speculative";

    private static final String INSERT_album_SQL = "INSERT INTO album (name, parts, country) VALUES (?, ?, ?)";
    private static final String SELECT_album_BY_ID = "SELECT id, name, parts,country  FROM album WHERE id = ?";
    private static final String SELECT_ALL_albumS = "SELECT * FROM album";
    private static final String DELETE_album_SQL = "DELETE FROM album WHERE id = ?";
    private static final String UPDATE_album_SQL = "UPDATE album SET name = ?, parts = ?, country = ? WHERE id = ?";

    public albumDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            // Handle or log the exception
        }
        return connection;
    }

    public void insertalbum(album album) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_album_SQL)) {
            preparedStatement.setString(1, album.getname());
            preparedStatement.setString(2, album.getparts());
            preparedStatement.setString(3, album.getcountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // Handle or log the exception
        }
    }

    public album selectalbum(int id) {
        album Album = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_album_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String parts = rs.getString("parts");
                String country = rs.getString("country");
                Album = new album(id, name, parts, country);
            }
        } catch (SQLException e) {
            // Handle or log the exception
        }
        return Album;
    }

    public List<album> selectAllalbums() {
        List<album> albums = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_albumS);
             ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String parts = rs.getString("parts");
                String country = rs.getString("country");
                albums.add(new album(id, name, parts, country));
            }
        } catch (SQLException e) {
            // Handle or log the exception
        }
        return albums;
    }

    public boolean deleteAlbum(int id) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_album_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            // Handle or log the exception
        }
        return rowDeleted;
    }

    public boolean updateAlbum(album album) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_album_SQL)) {
            statement.setString(1, album.getname());
            statement.setString(2, album.getparts());
            statement.setString(3, album.getcountry());
            statement.setInt(4, album.getId());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            // Handle or log the exception
        }
        return rowUpdated;
    }
}
