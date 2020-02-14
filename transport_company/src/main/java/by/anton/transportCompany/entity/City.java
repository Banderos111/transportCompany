package by.anton.transportCompany.entity;

public class City {
    private int id;
    private String name;
    private double longitude;
    private double latitude;
    private boolean airport;
    private boolean seaPort;

    public City(int id, String name, double longitude, double latitude, boolean airport, boolean seaPort) {
        this.id = id;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.airport = airport;
        this.seaPort = seaPort;
    }

    public City(String name, double longitude, double latitude, boolean airport, boolean seaPort) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.airport = airport;
        this.seaPort = seaPort;
    }

    public City() {
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

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public boolean isAirport() {
        return airport;
    }

    public void setAirport(boolean airport) {
        this.airport = airport;
    }

    public boolean isSeaPort() {
        return seaPort;
    }

    public void setSeaPort(boolean seaPort) {
        this.seaPort = seaPort;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", airport=" + airport +
                ", seaPort=" + seaPort +
                '}';
    }
}
