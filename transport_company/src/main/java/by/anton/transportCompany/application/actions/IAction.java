package by.anton.transportCompany.application.actions;

import by.anton.transportCompany.application.excaptions.StopApplicationException;

public interface IAction {
    String name();

    void action() throws StopApplicationException;
}
