package program.engine;

import program.model.*;
import program.model.Driver;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Admin on 31.03.2016.
 */
public class DBEncapsulator {

    private ArrayList<Driver> driversList = new ArrayList<program.model.Driver>();
    private ArrayList<Vehicle> vehiclesList = new ArrayList<Vehicle>();
    private ArrayList<Tariff> tariffsList = new ArrayList<Tariff>();
    private ArrayList<Status> statusList = new ArrayList<Status>();
    private ArrayList<Call> callsList = new ArrayList<Call>();

    private DBWorker worker = new DBWorker();

    public ArrayList<Driver> getDriversList() {
        return driversList;
    }

    public ArrayList<Vehicle> getVehiclesList() {
        return vehiclesList;
    }

    public ArrayList<Tariff> getTariffsList() {
        return tariffsList;
    }

    public ArrayList<Status> getStatusList() {
        return statusList;
    }

    public ArrayList<Call> getCallsList() {
        return callsList;
    }

    public DBWorker getWorker() {
        return worker;
    }

    public DBEncapsulator()
    {
        initializeDrivers();
        initializeVehicles();
        initializeTariffs();
        initializeStatus();
        initializeCalls();
    }


    private void initializeDrivers()
    {
        try
        {
            Statement statement = worker.getConnection().createStatement();
            ResultSet driversResultSet = statement.executeQuery(DBWorker.driversQuery);
            while(driversResultSet.next())
            {
                int id = driversResultSet.getInt("id");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(driversResultSet.getString("name") + " ");
                stringBuilder.append(driversResultSet.getString("lastname"));
                String name = stringBuilder.toString();
                program.model.Driver driver = new program.model.Driver(id, name);
                driversList.add(driver);
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    private void initializeVehicles()
    {
        try
        {
            Statement statement = worker.getConnection().createStatement();
            ResultSet vehiclesResultSet = statement.executeQuery(DBWorker.vehiclesQuery);
            while(vehiclesResultSet.next())
            {
                int id = vehiclesResultSet.getInt("id");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(vehiclesResultSet.getString("name") + " ");
                stringBuilder.append(vehiclesResultSet.getString("model") + " ");
                stringBuilder.append(vehiclesResultSet.getString("ser_number"));
                String name = stringBuilder.toString();
                int driverID = vehiclesResultSet.getInt("driver");
                program.model.Driver driver = null;

                for (program.model.Driver d : driversList)
                {
                    if (d.getId() == driverID) driver = d;
                }

                Vehicle vehicle = new Vehicle(id, name, driver);
                vehiclesList.add(vehicle);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    private void initializeTariffs()
    {
        try
        {
            Statement statement = worker.getConnection().createStatement();
            ResultSet tariffsResultSet = statement.executeQuery(DBWorker.tariffsQuery);
            while(tariffsResultSet.next())
            {
                int id = tariffsResultSet.getInt("id");
                String name = tariffsResultSet.getString("name");

                Tariff tariff = new Tariff(id, name);
                tariffsList.add(tariff);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    private void initializeStatus()
    {
        try
        {
            Statement statement = worker.getConnection().createStatement();
            ResultSet statusResultSet = statement.executeQuery(DBWorker.statusQuery);
            while(statusResultSet.next())
            {
                int id = statusResultSet.getInt("id");
                String name = statusResultSet.getString("name");

                Status status = new Status(id, name);
                statusList.add(status);
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    private void initializeCalls()
    {
        try
        {
            Statement statement = worker.getConnection().createStatement();
            ResultSet callsResultSet = statement.executeQuery(DBWorker.callsQuery);
            while(callsResultSet.next())
            {
                int id = callsResultSet.getInt("id");
                String client = callsResultSet.getString("client");
                String phoneNumber = callsResultSet.getString("phone_num");
                String from = callsResultSet.getString("p_from");
                String to = callsResultSet.getString("p_to");
                Time time = callsResultSet.getTime("time");
                Date date = callsResultSet.getDate("date");
                int driverID = callsResultSet.getInt("driver");
                int vehicleID = callsResultSet.getInt("vehicle");
                int tariffID = callsResultSet.getInt("tariff");
                int statusID = callsResultSet.getInt("status");

                Driver driver = null;
                for (Driver d : driversList)
                {
                    if (d.getId() == driverID) driver = d;
                }

                Vehicle vehicle = null;
                for (Vehicle v : vehiclesList)
                {
                    if(v.getId() == vehicleID) vehicle = v;
                }

                Tariff tariff = null;
                for (Tariff t : tariffsList)
                {
                    if(t.getId() == tariffID) tariff = t;
                }

                Status status = null;
                for (Status s : statusList)
                {
                    if (s.getId() == statusID) status = s;
                }

                //String number = String.format(phoneNumber, "%d%d%d-%d%d%d-%d%d%d");

                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                String dateS = df.format(date);

                df = new SimpleDateFormat("HH:mm");
                String timeS = df.format(time);

                Call call = new Call.Builder().id(id).client(client).phone(phoneNumber).
                        from(from).to(to).time(timeS).date(dateS).driver(driver).
                        vehicle(vehicle).tariff(tariff).status(status).build();

                callsList.add(call);

//                String out = String.format("%d | %s | %s | %s | %s | %s | %s | %s | %s | %s | %s", id, client, phoneNumber, from, to, timeS, dateS, driver, vehicle, tariff, status);
//
//                System.out.println(System.lineSeparator());
//                System.out.println(out);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

}
