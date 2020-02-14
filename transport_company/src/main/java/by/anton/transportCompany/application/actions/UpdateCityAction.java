package by.anton.transportCompany.application.actions;

import by.anton.transportCompany.application.utils.GetInput;
import by.anton.transportCompany.entity.City;

public class UpdateCityAction extends BaseCityAction implements IAction {
    @Override
    public String name() {
        return "редактировать город";
    }

    @Override
    public void action() {
        int id = GetInput.getInt("Введите id города, который хотите отредактировать");
        String name = GetInput.getString("Введите название города");
        double longitude = GetInput.getDouble("Введите долготу");
        double latitude = GetInput.getDouble("Введите широту");
        boolean airport = GetInput.getBoolean("Будет ли у нас аэропорт?\n" + "да - true\n" + "нет - false");
        boolean seaPort = GetInput.getBoolean("Будет ли у нас морской порт?\n" + "да - true\n" + "нет - false");
        City city = new City(id, name, longitude, latitude, airport, seaPort);
        cityController.updateCity(city);
    }
}
