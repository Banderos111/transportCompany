package by.anton.transportCompany.data.dao;

import by.anton.transportCompany.connector.MySqlConnector;
import by.anton.transportCompany.entity.City;
import by.anton.transportCompany.entity.User;

import java.sql.*;

public class UserDao {
    private static final String SELECT = "SELECT*FROM users WHERE login = ? AND password = ?";

    public User getUser(String login, int password) {
        User user = new User();
        try (Connection connection = MySqlConnector.getConnection()) {
           PreparedStatement preparedStatement = connection.prepareStatement(SELECT);
           preparedStatement.setString(1, login);
           preparedStatement.setInt(2, password);
            user = resultSetToUser(preparedStatement.executeQuery());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    private User resultSetToUser(ResultSet result) {
        User user = new User();
        try {
            while (result.next()) {
                user.setId(result.getInt("id"));
                user.setLogin(result.getString("login"));
                user.setPassword(result.getInt("password"));
                user.setRole(result.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
