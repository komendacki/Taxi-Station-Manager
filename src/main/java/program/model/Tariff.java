package program.model;

/**
 * Created by Admin on 31.03.2016.
 */
public class Tariff {
    private int id;
    private int name;

    public Tariff(int id, int name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getName() {
        return name;
    }
}
