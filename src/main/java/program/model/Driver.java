package program.model;

/**
 * Created by Admin on 31.03.2016.
 */
public class Driver {
    private int id;
    private String name;

    public Driver(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}