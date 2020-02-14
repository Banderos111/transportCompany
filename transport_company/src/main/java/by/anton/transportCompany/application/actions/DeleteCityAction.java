package by.anton.transportCompany.application.actions;

import by.anton.transportCompany.application.utils.GetInput;

public class DeleteCityAction extends BaseCityAction implements IAction {
    @Override
    public String name() {
        return "удалить город";
    }

    @Override
    public void action() {
        int id = GetInput.getInt("Введите id города, который хотите удалить");
        cityController.deleteCity(id);
    }
}
