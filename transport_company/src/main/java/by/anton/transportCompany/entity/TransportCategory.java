package by.anton.transportCompany.entity;

public class TransportCategory {
    private int id;
    private String name;

    public TransportCategory(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public TransportCategory(int id) {
        this.id = id;
    }

    public TransportCategory() {
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

    @Override
    public String toString() {
        return "TransportCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
