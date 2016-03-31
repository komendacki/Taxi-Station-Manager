package program.model;

/**
 * Created by Admin on 31.03.2016.
 */
public class Tariff {
    private int id;
    private String name;

    public Tariff(int id, String name) {
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
