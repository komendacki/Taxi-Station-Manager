package program.engine;

import program.gui.MainFrame;
import program.model.Status;
import program.model.Tariff;
import program.model.Vehicle;

import javax.swing.*;
import java.sql.SQLException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Admin on 23.03.2016.
 */
public class Main {

    public static void main(String[] args)
    {

        DBWorker worker = new DBWorker();
        ArrayList<program.model.Driver> driversList = new ArrayList<program.model.Driver>();
        ArrayList<Vehicle> vehiclesList = new ArrayList<Vehicle>();
        ArrayList<Tariff> tariffsList = new ArrayList<Tariff>();
        ArrayList<Status> statusList = new ArrayList<Status>();

//        String callsQuery = "SELECT * FROM calls";
//        String driversQuery = "SELECT id, name FROM workers WHERE position=2";
//        String vehiclesQuery = "SELECT id, name, model, driver FROM vehicles";
//        String tariffsQuery = "SELECT id, name FROM tariffs";
//        String statusQuery = "SELECT id, name FROM status";

        try
        {
            Statement statement = worker.getConnection().createStatement();


            ResultSet driversResultSet = statement.executeQuery(DBWorker.driversQuery);
            while(driversResultSet.next())
            {
                int id = driversResultSet.getInt(1);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(driversResultSet.getString(2) + " ");
                stringBuilder.append(driversResultSet.getString(3));
                String name = stringBuilder.toString();
                program.model.Driver driver = new program.model.Driver(id, name);
                driversList.add(driver);
            }

            ResultSet vehiclesResultSet = statement.executeQuery(DBWorker.vehiclesQuery);
            while(vehiclesResultSet.next())
            {
                int id = vehiclesResultSet.getInt(1);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(vehiclesResultSet.getString(2) + " ");
                stringBuilder.append(vehiclesResultSet.getString(3) + " ");
                stringBuilder.append(vehiclesResultSet.getString(4));
                String name = stringBuilder.toString();
                int driverID = vehiclesResultSet.getInt(5);
                program.model.Driver driver = null;

                for (program.model.Driver d : driversList)
                {
                    if (d.getId() == driverID) driver = d;
                }

                Vehicle vehicle = new Vehicle(id, name, driver);
                vehiclesList.add(vehicle);
            }

            ResultSet tariffsResultSet = statement.executeQuery(DBWorker.tariffsQuery);
            while(tariffsResultSet.next())
            {
                int id = tariffsResultSet.getInt(1);
                String name = tariffsResultSet.getString(2);

                Tariff tariff = new Tariff(id, name);
                tariffsList.add(tariff);
            }

            ResultSet statusResultSet = statement.executeQuery(DBWorker.statusQuery);
            while(statusResultSet.next())
            {
                int id = statusResultSet.getInt(1);
                String name = statusResultSet.getString(2);

                Status status = new Status(id, name);
                statusList.add(status);
            }


            ResultSet callsResultSet = statement.executeQuery(DBWorker.callsQuery);
            while(callsResultSet.next())
            {
                int id = callsResultSet.getInt(1);
                String client = callsResultSet.getString(2);
                String phoneNumber = callsResultSet.getString(3);
                String from = callsResultSet.getString(4);
                String to = callsResultSet.getString(5);
                Time time = callsResultSet.getTime(6);
                Date date = callsResultSet.getDate(7);
                String driver = callsResultSet.getString(8);
                String vehicle = callsResultSet.getString(9);
                String tariff = callsResultSet.getString(10);
                String status = callsResultSet.getString(11);

                //String number = String.format(phoneNumber, "%d%d%d-%d%d%d-%d%d%d");

                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                String dateS = df.format(date);

                df = new SimpleDateFormat("HH:mm");
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
