package program.engine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Admin on 30.03.2016.
 */
public class DBWorker {
    private static final String HOST = "jdbc:mysql://localhost:3306/taxi_station?autoReconnect=true&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1111";

    public static final String callsQuery = "SELECT * FROM calls";
    public static final String driversQuery = "SELECT id, name, lastname FROM workers WHERE position=2";
    public static final String vehiclesQuery = "SELECT id, name, model, ser_number, driver FROM vehicles";
    public static final String tariffsQuery = "SELECT id, name FROM tariffs";
    public static final String statusQuery = "SELECT id, name FROM status";

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public DBWorker()
    {
        try
        {
            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
