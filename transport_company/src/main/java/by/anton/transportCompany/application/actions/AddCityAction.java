package by.anton.transportCompany.application.actions;


import by.anton.transportCompany.application.utils.GetInput;
import by.anton.transportCompany.entity.City;

public class AddCityAction extends BaseCityAction implements IAction {
    @Override
    public String name() {
        return "добавить город";
    }

    @Override
    public void action() {
        String name = GetInput.getString("Введите название города");
        double longitude = GetInput.getDouble("Введите долготу");
        double latitude = GetInput.getDouble("Введите широту");
        boolean airport = GetInput.getBoolean("Будет ли у нас аэропорт?\n" + "да - 1\n" + "нет - 0");
        boolean seaPort = GetInput.getBoolean("Будет ли у нас морской порт?\n" + "да - 1\n" + "нет - 0");
        City city = new City(name, longitude, latitude, airport, seaPort);
        cityController.createCity(city);
    }
}
