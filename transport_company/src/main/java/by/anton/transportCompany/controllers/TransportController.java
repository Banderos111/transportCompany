package by.anton.transportCompany.controllers;

import by.anton.transportCompany.data.dao.ITransportDao;
import by.anton.transportCompany.data.dao.TransportDaoImpl;
import by.anton.transportCompany.entity.Transport;

import java.util.List;

public class TransportController {
    ITransportDao transportDao = new TransportDaoImpl();

    public void createTransport(Transport transport){
        transportDao.createTransport(transport);
    }

    public void deleteTransport(int id){
        transportDao.deleteTransport(id);
    }

    public void updateTransport(Transport transport){
        transportDao.updateTransport(transport);
    }

    public List<Transport> getAllTransport(){
        return transportDao.getAllTransport();
    }

    public List<Transport> getTransportByCategoryAndCapacity(int category, int capacityPeople, int capacityCargo){
        return transportDao.getTransportByCategoryAndCapacity(category, capacityPeople, capacityCargo);
    }
}
