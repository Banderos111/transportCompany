package by.anton.transportCompany.data.dao;

import by.anton.transportCompany.connector.MySqlConnector;
import by.anton.transportCompany.entity.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDaoImpl implements ICityDao {
    private static final String CREATE = "INSERT INTO citys VALUES (null, ?, ?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM citys WHERE id=?";
    private static final String UPDATE = "UPDATE citys SET name = ?, longitude = ?, latitude = ?, airport = ?, sea_port = ? WHERE id = ?";
    private static final String SELECT_ALL_CITYS = "SELECT*FROM citys";
    private static final String SELECT_CITY="SELECT*FROM citys WHERE name = ?";

    @Override
    public void createCity(City city) {
        try (Connection connection = MySqlConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE);
            preparedStatement.setString(1, city.getName());
            preparedStatement.setDouble(2, city.getLongitude());
            preparedStatement.setDouble(3, city.getLatitude());
            preparedStatement.setBoolean(4, city.isAirport());
            preparedStatement.setBoolean(5, city.isSeaPort());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCity(int id) {
        try (Connection connection = MySqlConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCity(City city) {
        try (Connection connection = MySqlConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, city.getName());
            preparedStatement.setDouble(2, city.getLongitude());
            preparedStatement.setDouble(3, city.getLatitude());
            preparedStatement.setBoolean(4, city.isAirport());
            preparedStatement.setBoolean(5, city.isSeaPort());
            preparedStatement.setInt(6, city.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<City> getAllCitys() {
        List<City> citys = new ArrayList<>();
        try (Connection connection = MySqlConnector.getConnection()) {
            Statement statement = connection.createStatement();
            citys = resultSetToList(statement.executeQuery(SELECT_ALL_CITYS));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return citys;
    }

    @Override
    public City getCity(String nameCity) {
        City city = new City();
        try (Connection connection = MySqlConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CITY);
            preparedStatement.setString(1, nameCity);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                city.setId(resultSet.getInt("id"));
                city.setName(resultSet.getString("name"));
                city.setLongitude(resultSet.getDouble("longitude"));
                city.setLatitude(resultSet.getDouble("latitude"));
                city.setAirport(resultSet.getBoolean("airport"));
                city.setSeaPort(resultSet.getBoolean("sea_port"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }


    private List<City> resultSetToList(ResultSet result) {
        List<City> citys = new ArrayList<>();
        try {
            while (result.next()) {
                City city = new City();
                city.setId(result.getInt("id"));
                city.setName(result.getString("name"));
                city.setLongitude(result.getDouble("longitude"));
                city.setLatitude(result.getDouble("latitude"));
                city.setAirport(result.getBoolean("airport"));
                city.setSeaPort(result.getBoolean("sea_port"));
                citys.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return citys;
    }

}
