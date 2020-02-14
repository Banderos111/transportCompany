package by.anton.transportCompany.entity;

public class Transport {
    private int id;
    private String name;
    private int speed;
    private int capacityPeople;
    private int capacityCargo;
    private TransportCategory category;
    private int priceToKillometer;

    public Transport(int id, String name, int speed, int capacityPeople, int capacityCargo, TransportCategory category, int priceToKillometr) {
        this.id = id;
        this.name = name;
        this.speed = speed;
        this.capacityPeople = capacityPeople;
        this.capacityCargo = capacityCargo;
        this.category = category;
        this.priceToKillometer = priceToKillometr;
    }

    public Transport(String name, int speed, int capacityPeople, int capacityCargo, TransportCategory category, int priceToKillometr) {
        this.name = name;
        this.speed = speed;
        this.capacityPeople = capacityPeople;
        this.capacityCargo = capacityCargo;
        this.category = category;
        this.priceToKillometer = priceToKillometr;
    }

    public Transport() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getCapacityPeople() {
        return capacityPeople;
    }

    public void setCapacityPeople(int capacityPeople) {
        this.capacityPeople = capacityPeople;
    }

    public int getCapacityCargo() {
        return capacityCargo;
    }

    public void setCapacityCargo(int capacityCargo) {
        this.capacityCargo = capacityCargo;
    }

    public TransportCategory getCategory() {
        return category;
    }

    public void setCategory(TransportCategory category) {
        this.category = category;
    }

    public int getPriceToKillometer() {
        return priceToKillometer;
    }

    public void setPriceToKillometer(int priceToKillometer) {
        this.priceToKillometer = priceToKillometer;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", speed=" + speed +
                ", capacityPeople=" + capacityPeople +
                ", capacityCargo=" + capacityCargo +
                ", category=" + category +
                ", priceToKillometer=" + priceToKillometer +
                '}';
    }
}
