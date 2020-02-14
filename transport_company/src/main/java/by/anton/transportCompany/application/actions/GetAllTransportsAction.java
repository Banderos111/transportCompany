package by.anton.transportCompany.application.actions;

import by.anton.transportCompany.entity.Transport;

public class GetAllTransportsAction extends BaseTransportAction implements IAction {
    @Override
    public String name() {
        return "получить весь список транспорта";
    }

    @Override
    public void action() {
        for (Transport transport:  transportController.getAllTransport()) {
            System.out.println(transport);
        }

    }
}
