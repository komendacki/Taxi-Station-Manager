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

    public void setTo(String to) {
        this.to = to;
    }

    public static class Builder
    {
        private int builderId;
        private String builderClient;
        private String builderPhone;
        private String builderFrom;
        private String builderTo;
        private String builderTime;
        private String builderDate;
        private Driver builderDriver;
        private Vehicle builderVehicle;
        private Tariff builderTariff;
        private Status builderStatus;

        public Builder id(int id){this.builderId = id; return this;}
        public Builder client(String client){this.builderClient = client; return this;}
        public Builder phone(String phone){this.builderPhone = phone; return this;}
        public Builder from(String from){this.builderFrom = from; return this;}
        public Builder to(String to){this.builderTo = to; return this;}
        public Builder time(String time){this.builderTime = time; return this;}
        public Builder date(String date){this.builderDate = date; return this;}
        public Builder driver(Driver driver){this.builderDriver = driver; return this;}
        public Builder vehicle(Vehicle vehicle){this.builderVehicle = vehicle; return this;}
        public Builder tariff(Tariff tariff){this.builderTariff = tariff; return this;}
        public Builder status(Status status){this.builderStatus = status; return this;}

        public Call build()
        {
            return new Call(this);
        }
    }



    private Call(Builder builder)
    {
        this.id = builder.builderId;
        this.client = builder.builderClient;
        this.phone = builder.builderPhone;
        this.from = builder.builderFrom;
        this.to = builder.builderTo;
        this.time = builder.builderTime;
        this.date = builder.builderDate;
        this.driver = builder.builderDriver;
        this.vehicle = builder.builderVehicle;
        this.tariff = builder.builderTariff;
        this.status = builder.builderStatus;
    }

    @Override
    public String toString() {
        return "builderId=" + id +
                ", builderClient='" + client + '\'' +
                ", builderPhone='" + phone + '\'' +
                ", builderFrom='" + from + '\'' +
                ", builderTo='" + to + '\'' +
                ", builderTime='" + time + '\'' +
                ", builderDate='" + date + '\'' +
                ", builderDriver=" + driver +
                ", builderVehicle=" + vehicle +
                ", builderTariff=" + tariff +
                ", builderStatus=" + status;
    }
}
