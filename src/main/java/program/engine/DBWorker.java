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
