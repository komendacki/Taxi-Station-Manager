package program.engine;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import program.gui.MainFrame;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.sql.*;

/**
 * Created by Admin on 23.03.2016.
 */
public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/my_testdb?autoReconnect=true&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1111";

    public static void main(String[] args)
    {

        Connection connection;

        try
        {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();

            if (!connection.isClosed())
            {
                System.out.println("Connected");
            }

            SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                    JFrame frame = new MainFrame("Taxi Station Manager");
                    frame.setSize(600, 500);

                    String[][] data = {{"01", "Alex", "18"}, {"02", "Brandon", "20"}, {"03", "Cassie", "18"}, {"04", "Steve", "25"}};
                    String[] column = {"ID", "Name", "Age"};

                    // Create JTable
                    JTable jt = new JTable(data, column);
                    JScrollPane sp = new JScrollPane(jt);

                    frame.add(sp);
                    frame.pack();


                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);


                }
            });
        }
        catch(SQLException e)
        {

        }



    }
}
