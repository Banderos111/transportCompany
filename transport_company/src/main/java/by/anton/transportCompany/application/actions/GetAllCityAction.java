package by.anton.transportCompany.application.actions;

import by.anton.transportCompany.entity.City;

public class GetAllCityAction extends BaseCityAction implements IAction {
    @Override
    public String name() {
        return "получить весь список городов";
    }

    @Override
    public void action() {
        for (City city: cityController.getAllCity()) {
            System.out.println(city);
        }
    }
}
