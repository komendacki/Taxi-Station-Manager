package program.model;

/**
 * Created by Admin on 31.03.2016.
 */
public class Vehicle {
    private int id;
    private String name;
//    private String model;
//    private String number;
    private Driver driver;

//    public Vehicle(int id, String name, String model, String number, Driver driver) {
//        this.id = id;
//        this.name = name;
//        this.model = model;
//        this.number = number;
//        this.driver = driver;
//    }

    public Vehicle(int id, String name, Driver driver)
    {
        this.id = id;
        this.name = name;
        this.driver = driver;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

//    public String getModel() {
//        return model;
//    }
//
//    public String getNumber() {
//        return number;
//    }

    public Driver getDriver() {
        return driver;
    }

    @Override
    public String toString() {
        return name;
    }
}
