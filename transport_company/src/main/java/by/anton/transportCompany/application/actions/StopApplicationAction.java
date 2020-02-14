package by.anton.transportCompany.application.actions;

import by.anton.transportCompany.application.excaptions.StopApplicationException;

public class StopApplicationAction implements IAction {
    @Override
    public String name() {
        return "выход";
    }

    @Override
    public void action() throws StopApplicationException {
        throw new StopApplicationException();
    }
}
