package by.anton.transportCompany.data.dao;

import by.anton.transportCompany.entity.City;

import java.util.List;

public interface ICityDao {
    void createCity(City city);

    void deleteCity(int id);

    void updateCity(City city);

    List<City> getAllCitys();

    City getCity(String city);

}
