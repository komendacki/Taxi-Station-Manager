package program.model;

/**
 * Created by Admin on 30.03.2016.
 */
public class Call {

    private int id;
    private String client;
    private String phone;
    private String from;
    private String to;
    private String time;
    private String date;
    private Driver driver;
    private Vehicle vehicle;
    private Tariff tariff;
    private Status status;
//    private String driver;
//    private int driverID;
//    private String vehicle;
//    private int vehicleID;
//    private String tariff;
//    private String status;

    public int getId() {
        return id;
    }

    public String getClient() {
        return client;
    }

    public String getPhone() {
        return phone;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public Driver getDriver() {
        return driver;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    //    public String getDriver() {
//        return driver;
//    }
//
//    public int getDriverID() {
//        return driverID;
//    }
//
//    public String getVehicle() {
//        return vehicle;
//    }
//
//    public int getVehicleID() {
//        return vehicleID;
//    }
//
//    public String getTariff() {
//        return tariff;
//    }

//    public String getStatus() {
//        return status;
//    }

    public void setTo(String to) {
        this.to = to;
    }

//    public void setDriver(String driver) {
//        this.driver = driver;
//    }
//
//    public void setDriverID(int driverID) {
//        this.driverID = driverID;
//    }

//    public void setVehicle(String vehicle) {
//        this.vehicle = vehicle;
//    }
//
//    public void setVehicleID(int vehicleID) {
//        this.vehicleID = vehicleID;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }

    public static class Builder
    {
        private int id;
        private String client;
        private String phone;
        private String from;
        private String to;
        private String time;
        private String date;
        private Driver driver;
        private Vehicle vehicle;
        private Tariff tariff;
        private Status status;
//        private String driver;
//        private int driverID;
//        private String vehicle;
//        private int vehicleID;
//        private String tariff;
//        private String status;

        public Builder id(int id){this.id = id; return this;}
        public Builder client(String client){this.client = client; return this;}
        public Builder phone(String phone){this.phone = phone; return this;}
        public Builder from(String from){this.from = from; return this;}
        public Builder to(String to){this.to = to; return this;}
        public Builder time(String time){this.time = time; return this;}
        public Builder date(String date){this.date = date; return this;}
        public Builder driver(Driver driver){this.driver = driver; return this;}
        public Builder vehicle(Vehicle vehicle){this.vehicle = vehicle; return this;}
        public Builder tariff(Tariff tariff){this.tariff = tariff; return this;}
        public Builder status(Status status){this.status = status; return this;}
//        public Builder driverID(int id){this.driverID = id; return this;}
//        public Builder driver(String driver){this.driver = driver; return this;}
//        public Builder vehicleID(int id){this.vehicleID = id; return this;}
//        public Builder vehicle(String vehicle){this.vehicle = vehicle; return this;}
//        public Builder tariff(String tariff){this.tariff = tariff; return this;}
//        public Builder status(String status){this.status = tariff; return this;}

        public Call build()
        {
            return new Call(this);
        }
    }



    private Call(Builder builder)
    {
        this.id = builder.id;
        this.client = builder.client;
        this.phone = builder.phone;
        this.from = builder.from;
        this.to = builder.to;
        this.time = builder.time;
        this.date = builder.date;
        this.driver = builder.driver;
        this.vehicle = builder.vehicle;
        this.tariff = builder.tariff;
        this.status = builder.status;
    }

    @Override
    public String toString() {
        return "Call{" +
                "id=" + id +
                ", client='" + client + '\'' +
                ", phone='" + phone + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", time='" + time + '\'' +
                ", date='" + date + '\'' +
                ", driver=" + driver +
                ", vehicle=" + vehicle +
                ", tariff=" + tariff +
                ", status=" + status +
                '}';
    }
}
