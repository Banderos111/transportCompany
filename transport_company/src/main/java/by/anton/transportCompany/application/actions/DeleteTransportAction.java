package by.anton.transportCompany.application.actions;

import by.anton.transportCompany.application.utils.GetInput;

public class DeleteTransportAction extends BaseTransportAction implements IAction {
    @Override
    public String name() {
        return "удалить транспорт";
    }

    @Override
    public void action() {
        int id = GetInput.getInt("Введите id транспорта, который хотите удалить");
        transportController.deleteTransport(id);
    }
}
