package by.anton.transportCompany.application;

import by.anton.transportCompany.application.actions.*;
import by.anton.transportCompany.application.excaptions.StopApplicationException;
import by.anton.transportCompany.application.utils.GetInput;
import by.anton.transportCompany.data.dao.UserDao;
import by.anton.transportCompany.entity.User;

import java.util.HashMap;
import java.util.Map;

public class Application {
    private HashMap<Integer, IAction> actionsForUser = new HashMap<>();
    private HashMap<Integer, IAction> actionsForAdmin = new HashMap<>();
    private UserDao userDao = new UserDao();

    public Application() {
        actionsForUser.put(1, new RoutCostAction());
        actionsForUser.put(2, new StopApplicationAction());

        actionsForAdmin.put(1, new GetAllCityAction());
        actionsForAdmin.put(2, new AddCityAction());
        actionsForAdmin.put(3, new UpdateCityAction());
        actionsForAdmin.put(4, new DeleteCityAction());
        actionsForAdmin.put(5, new GetAllTransportsAction());
        actionsForAdmin.put(6, new AddTransportAction());
        actionsForAdmin.put(7, new UpdateTransportAction());
        actionsForAdmin.put(8, new DeleteTransportAction());
        actionsForAdmin.put(9, new RoutCostAction());
        actionsForAdmin.put(10, new StopApplicationAction());
    }

    public void start() {
        String login = GetInput.getString("введите логин");
        int password = GetInput.getInt("введите пароль");
        User user = userDao.getUser(login, password);
        if (user.getRole().equals("user")) {
            runForUser();
        }
        if (user.getRole().equals("admin")) {
            runForAdmin();
        }
        System.out.println("Всего доброго!");
    }


    private void runForUser() {
        while (true) {
            IAction action = getActionForUser();
            try {
                action.action();
            } catch (StopApplicationException e) {
                break;
            }
        }
    }


    private IAction getActionForUser() {
        showMenuForUser();
        int action = GetInput.getInt();
        if (actionsForUser.containsKey(action)) {
            return actionsForUser.get(action);
        }
        System.out.println("Нет такого действия");
        return getActionForUser();
    }

    private void showMenuForUser() {
        System.out.println("Выберите действие");
        for (Map.Entry<Integer, IAction> action : actionsForUser.entrySet()) {
            System.out.println(action.getKey() + " - " + action.getValue().name());
        }
    }

    private void runForAdmin() {
        while (true) {
            IAction action = getActionForAdmin();
            try {
                action.action();
            } catch (StopApplicationException e) {
                break;
            }

        }
    }

    private IAction getActionForAdmin() {
        showMenuForAdmin();
        int action = GetInput.getInt();
        if (actionsForAdmin.containsKey(action)) {
            return actionsForAdmin.get(action);
        }
        System.out.println("Нет такого действия");
        return getActionForAdmin();
    }

    private void showMenuForAdmin() {
        System.out.println("Выберите действие");
        for (Map.Entry<Integer, IAction> action : actionsForAdmin.entrySet()) {
            System.out.println(action.getKey() + " - " + action.getValue().name());
        }
    }
}
