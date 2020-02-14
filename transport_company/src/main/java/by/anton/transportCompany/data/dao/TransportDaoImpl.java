package by.anton.transportCompany.data.dao;

import by.anton.transportCompany.connector.MySqlConnector;
import by.anton.transportCompany.entity.Transport;
import by.anton.transportCompany.entity.TransportCategory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransportDaoImpl implements ITransportDao {
    private static final String CREATE = "INSERT INTO transports VALUES (null, ?, ?, ?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM transports WHERE id=?";
    private static final String UPDATE = "UPDATE transports SET name = ?, speed = ?, passengers_number = ?, load_capacity = ?, type = ?, kilometer_price = ? WHERE id = ?";
    private static final String SELECT = "SELECT t.*, c.name AS category_name FROM transports t LEFT JOIN categories c ON t.type = c.id";
    private static final String SELECT_BY_CATEGORY_AND_CAPACITY = "SELECT t.*, c.name AS category_name FROM transports t LEFT JOIN categories c ON t.type = c.id WHERE type = ? AND passengers_number >= ? AND load_capacity >= ?";

    @Override
    public void createTransport(Transport transport) {
        try (Connection connection = MySqlConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE);
            preparedStatement.setString(1, transport.getName());
            preparedStatement.setInt(2, transport.getSpeed());
            preparedStatement.setInt(3, transport.getCapacityPeople());
            preparedStatement.setInt(4, transport.getCapacityCargo());
            preparedStatement.setInt(5, transport.getCategory().getId());
            preparedStatement.setInt(6, transport.getPriceToKillometer());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTransport(int id) {
        try (Connection connection = MySqlConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTransport(Transport transport) {
        try (Connection connection = MySqlConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, transport.getName());
            preparedStatement.setInt(2, transport.getSpeed());
            preparedStatement.setInt(3, transport.getCapacityPeople());
            preparedStatement.setInt(4, transport.getCapacityCargo());
            preparedStatement.setInt(5, transport.getCategory().getId());
            preparedStatement.setInt(6, transport.getPriceToKillometer());
            preparedStatement.setInt(7, transport.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Transport> getAllTransport() {
        List<Transport> transports = new ArrayList<>();
        try (Connection connection = MySqlConnector.getConnection()) {
            Statement statement = connection.createStatement();
            transports = resultSetToList(statement.executeQuery(SELECT));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transports;
    }

    @Override
    public List<Transport> getTransportByCategoryAndCapacity(int category, int capacityPeople, int capacityCargo) {
        List<Transport> transports = new ArrayList<>();
        try (Connection connection = MySqlConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_CATEGORY_AND_CAPACITY);
            preparedStatement.setInt(1, category);
            preparedStatement.setInt(2, capacityPeople);
            preparedStatement.setInt(3, capacityCargo);
            transports = resultSetToList(preparedStatement.executeQuery());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transports;
    }

    private List<Transport> resultSetToList(ResultSet result) {
        List<Transport> transports = new ArrayList<>();
        try {
            while (result.next()) {
                Transport transport = new Transport();
                transport.setId(result.getInt("id"));
                transport.setName(result.getString("name"));
                transport.setSpeed(result.getInt("speed"));
                transport.setCapacityPeople(result.getInt("passengers_number"));
                transport.setCapacityCargo(result.getInt("load_capacity"));
                transport.setCategory(new TransportCategory(result.getInt("type"), result.getString("category_name")));
                transport.setPriceToKillometer(result.getInt("kilometer_price"));
                transports.add(transport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transports;
    }
}
