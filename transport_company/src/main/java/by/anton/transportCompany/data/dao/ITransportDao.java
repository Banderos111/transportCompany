package by.anton.transportCompany.data.dao;

import by.anton.transportCompany.entity.Transport;

import java.util.List;

public interface ITransportDao {
    void createTransport(Transport transport);

    void deleteTransport(int id);

    void updateTransport(Transport transport);

    List<Transport> getAllTransport();

    List<Transport> getTransportByCategoryAndCapacity(int category, int capacityPeople, int capacityCargo);

}
