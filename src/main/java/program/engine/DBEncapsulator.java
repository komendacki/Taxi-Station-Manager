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

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String LASTNAME = "lastname";
    private static final String DRIVER = "driver";
    private static final String VEHICLE = "vehicle";
    private static final String MODEL = "model";
    private static final String SER_NUMBER = "ser_number";
    private static final String TARIFF = "tariff";
    private static final String STATUS = "status";
    private static final String FROM = "p_from";
    private static final String TO = "p_to";
    private static final String TIME = "time";
    private static final String DATE = "date";
    private static final String CLIENT = "client";
    private static final String PHONE = "phone_num";

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
                int id = driversResultSet.getInt(ID);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(driversResultSet.getString(NAME) + " ");
                stringBuilder.append(driversResultSet.getString(LASTNAME));
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
                int id = vehiclesResultSet.getInt(ID);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(vehiclesResultSet.getString(NAME) + " ");
                stringBuilder.append(vehiclesResultSet.getString(MODEL) + " ");
                stringBuilder.append(vehiclesResultSet.getString(SER_NUMBER));
                String name = stringBuilder.toString();
                int driverID = vehiclesResultSet.getInt(DRIVER);
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
                int id = tariffsResultSet.getInt(ID);
                String name = tariffsResultSet.getString(NAME);

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
                int id = statusResultSet.getInt(ID);
                String name = statusResultSet.getString(NAME);

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
                int id = callsResultSet.getInt(ID);
                String client = callsResultSet.getString(CLIENT);
                String phoneNumber = callsResultSet.getString(PHONE);
                String from = callsResultSet.getString(FROM);
                String to = callsResultSet.getString(TO);
                Time time = callsResultSet.getTime(TIME);
                Date date = callsResultSet.getDate(DATE);
                int driverID = callsResultSet.getInt(DRIVER);
                int vehicleID = callsResultSet.getInt(VEHICLE);
                int tariffID = callsResultSet.getInt(TARIFF);
                int statusID = callsResultSet.getInt(STATUS);

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

                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                String dateS = df.format(date);

                df = new SimpleDateFormat("HH:mm");
                String timeS = df.format(time);

                Call call = new Call.Builder().id(id).client(client).phone(phoneNumber).
                        from(from).to(to).time(timeS).date(dateS).driver(driver).
                        vehicle(vehicle).tariff(tariff).status(status).build();

                callsList.add(call);
//                String out = String.format("%d | %s | %s | %s | %s | %s | %s | %s | %s | %s | %s", id, client, phoneNumber, from, to, timeS, dateS, driver, vehicle, tariff, status);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

}
