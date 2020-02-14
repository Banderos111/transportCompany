package by.anton.transportCompany.application.actions;

import by.anton.transportCompany.application.utils.GetInput;
import by.anton.transportCompany.entity.Transport;
import by.anton.transportCompany.entity.TransportCategory;

public class UpdateTransportAction extends BaseTransportAction implements IAction {
    @Override
    public String name() {
        return "редактировать транспорт";
    }

    @Override
    public void action() {
        int id = GetInput.getInt("Введите id транспорта, который хотите отредактировать");
        String name = GetInput.getString("Введите название транспорта");
        int speed = GetInput.getInt("Введите скорость");
        int capacityPeople = GetInput.getInt("Введите количество пассажиромест");
        int capacityCargo = GetInput.getInt("Введите грузоподъемность");
        int category = GetInput.getInt("Введите номер категории\n" + "1 - наземный\n" + "2 - воздушный\n" + "3 - морской");
        int price = GetInput.getInt("Введите стоимость перевозки за киллометр");
        TransportCategory transportCategory = new TransportCategory(category);
        Transport transport = new Transport(id, name, speed, capacityPeople, capacityCargo, transportCategory, price);

        transportController.updateTransport(transport);
    }
}
