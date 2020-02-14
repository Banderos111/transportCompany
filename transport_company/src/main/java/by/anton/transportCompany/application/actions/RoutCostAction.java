package by.anton.transportCompany.application.actions;

import by.anton.transportCompany.application.utils.GetInput;
import by.anton.transportCompany.entity.City;
import by.anton.transportCompany.entity.Transport;

import java.util.ArrayList;
import java.util.List;

public class RoutCostAction implements IAction {
    private BaseCityAction cityAction = new BaseCityAction();
    private BaseTransportAction transportAction = new BaseTransportAction();

    @Override
    public String name() {
        return "подобрать маршрут из точки А в точку B";
    }

    @Override
    public void action() {
        List<Transport> transportList = new ArrayList<>();
        String cityName1 = GetInput.getString("Назовите город, из которого стартуем");
        String cityName2 = GetInput.getString("Назовите город - конечный пункт");
        City city1 = cityAction.cityController.getCity(cityName1);
        City city2 = cityAction.cityController.getCity(cityName2);
        int capacityPeople = GetInput.getInt("Сколько человек повезем?");
        int capacityCargo = GetInput.getInt("Сколько тонн груза повезем?");
        transportList.addAll(transportAction.transportController.getTransportByCategoryAndCapacity(1, capacityPeople, capacityCargo));
        if (city1.isAirport() && city2.isAirport()) {
            transportList.addAll(transportAction.transportController.getTransportByCategoryAndCapacity(2, capacityPeople, capacityCargo));
        }
        if (city1.isSeaPort() && city2.isSeaPort()) {
            transportList.addAll(transportAction.transportController.getTransportByCategoryAndCapacity(3, capacityPeople, capacityCargo));
        }

        if (!transportList.isEmpty()) {
            int distance = getDistance(city1, city2);
            int indexOfBestRout = 0;
            int bestSpeed = transportList.get(0).getSpeed();
            int bestPrice = transportList.get(0).getPriceToKillometer();
            for (int i = 0; i < transportList.size(); i++) {
                Transport transport = transportList.get(i);
                if (transport.getSpeed() > bestSpeed && transport.getPriceToKillometer() < bestPrice) {
                    indexOfBestRout = i;
                    bestPrice = transport.getPriceToKillometer();
                    bestSpeed = transport.getSpeed();
                }
            }
            System.out.println("Самый быстрый транспорт для доставки " + capacityPeople + " человек и " + capacityCargo +
                    "т груза из " + cityName1 + " в " + cityName2 + " - это " + transportList.get(indexOfBestRout).getName() +
                    ". Время в пути " + distance / bestSpeed + " ч. Стоимость " + distance * bestPrice + " $.");
        }
    }

    //какая-то отсебяшная, бредовая формула для расчета расстояния
    private int getDistance(City city1, City city2) {
        return (int) (city1.getLongitude() + city1.getLatitude() + city2.getLongitude() + city2.getLatitude()) * 23;
    }
}
