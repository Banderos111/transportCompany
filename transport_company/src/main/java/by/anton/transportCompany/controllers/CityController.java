package by.anton.transportCompany.controllers;

import by.anton.transportCompany.data.dao.CityDaoImpl;
import by.anton.transportCompany.data.dao.ICityDao;
import by.anton.transportCompany.entity.City;

import java.util.List;

public class CityController {
    ICityDao cityDao = new CityDaoImpl();

    public void createCity(City city) {
        cityDao.createCity(city);
    }

    public void deleteCity(int id) {
        cityDao.deleteCity(id);
    }

    public void updateCity(City city) {
        cityDao.updateCity(city);
    }

    public List<City> getAllCity() {
        return cityDao.getAllCitys();
    }

    public City getCity(String city) {
        return cityDao.getCity(city);
    }
}
