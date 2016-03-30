package program.engine;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import program.gui.MainFrame;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Admin on 23.03.2016.
 */
public class Main {

    public static void main(String[] args)
    {

        DBWorker worker = new DBWorker();

        String query = "SELECT * FROM calls";

        try
        {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next())
            {
                int id = resultSet.getInt(1);
                String client = resultSet.getString(2);
                String phoneNumber = resultSet.getString(3);
                String from = resultSet.getString(4);
                String to = resultSet.getString(5);
                Time time = resultSet.getTime(6);
                Date date = resultSet.getDate(7);
                String driver = resultSet.getString(8);
                String vehicle = resultSet.getString(9);
                String tariff = resultSet.getString(10);
                String status = resultSet.getString(11);

                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                String dateS = df.format(date);
                String timeS = df.format(time);

                String out = String.format("%d | %s | %s | %s | %s | %s | %s | %s | %s | %s | %s", id, client, phoneNumber, from, to, timeS, dateS, driver, vehicle, tariff, status);

                System.out.println(System.lineSeparator());
                System.out.println(out);
            }

            SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                    JFrame frame = new MainFrame("Taxi Station Manager");
                    frame.setSize(800, 800);

                    String[][] data = {{"01", "Alex", "18", "18", null, null, null, null, null}, {"02", "Brandon", "20", "20", null, null, null, null, null}, {"03", "Cassie", "18", "18", null, null, null, null, null}, {"04", "Steve", "25", "25", null, null, null, null, null}};
                    String[] column = {"ID", "Client", "Phone", "From", "To", "Time", "Driver", "Vehicle",  "Status"};

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
        catch (SQLException e)
        {
            e.printStackTrace();
        }


    }
}
