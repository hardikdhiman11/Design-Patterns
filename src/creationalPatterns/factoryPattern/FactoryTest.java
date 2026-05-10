package creationalPatterns.factoryPattern;


/**
 * Factory Pattern
 *
 *
 *  Entities
 *  ---------------------
 *  Vehicle
 *      - Two Wheeler
 *      - Four Wheeler
 *      - Eight Wheeler
 *  Engine
 *  Brand
 *
 *
 *
 *
 */



public class FactoryTest {

    /**
     * First i will show how without a centralized Factory class making objects is harder to maintain and the logic is
     * scattered all over.
     *
     *
     * Lets say in the future CEO wants customized engines for all the cars. Then changing the vehicle creation logic
     * everywhere where the vehicles are initialized would be a nightmare. Instead we should seperate out the object
     * creation logic itself so that changing the logic is easy for us.
     *
     */
    Vehicle bike1 = new Bike(Brand.BMW,"1231323");
    Vehicle bike2 = new Bike(Brand.BMW,"1231323");

    Vehicle truck1 = new Truck(Brand.TATA,"1231323");
    Vehicle truck2 = new Truck(Brand.TATA,"4563462");

    Vehicle car1 = new Car(Brand.MERCEDES,"45452463");
    Vehicle car2 = new Car(Brand.AUDI,"45452WSDEQWE63");

    Vehicle buggy1 = new Buggy(Brand.HONDA,"3294872309");
    Vehicle buggy2 = new Buggy(Brand.HONDA,"45452WSDHGTHJGYE63");


    VehicleFactory bikeFactory = new BikeFactory();
    VehicleFactory carFactory = new CarFactory();
    VehicleFactory truckFactory = new TruckFactory();
    VehicleFactory buggyFactory = new BuggyFactory();


    //Here we are making the objects by ourselves which is not a scalable solution to handle the object creation.
    //Instead of manually handling all this object creation. Handle this task to a factory class.
    Vehicle bikeFromFactory = bikeFactory.getVehicle(Brand.BMW,"123489432874698");
    Vehicle carFromFactory = carFactory.getVehicle(Brand.HONDA,"342589273456");
    Vehicle truckFromFactory = truckFactory.getVehicle(Brand.TATA,"457982346952394576");
    Vehicle buggyFromFactory = buggyFactory.getVehicle(Brand.HYUNDAI,"646952334235466");


}


interface VehicleFactory{
    Vehicle getVehicle(Brand brand,String licenseNumber);
}

class BikeFactory implements VehicleFactory{
    @Override
    public Vehicle getVehicle( Brand brand, String licenseNumber) {
        return new Bike(brand,licenseNumber);
    }
}

class CarFactory implements VehicleFactory{
    @Override
    public Vehicle getVehicle(Brand brand, String licenseNumber) {
        return new Car(brand,licenseNumber);
    }
}

class BuggyFactory implements VehicleFactory{
    @Override
    public Vehicle getVehicle(Brand brand, String licenseNumber) {
        return new Buggy(brand,licenseNumber);
    }
}

class TruckFactory implements VehicleFactory{
    @Override
    public Vehicle getVehicle(Brand brand, String licenseNumber) {
        return new Truck(brand,licenseNumber);
    }
}



enum VehicleModel{
    BIKE,
    CAR,
    BUGGY,
    TRUCK
}

enum VehicleType{
    TWO_WHEELER,
    FOUR_WHEELER,
    EIGHT_WHEELER
}

enum Brand{
    MARUTI,
    HYUNDAI,
    HONDA,
    SKODA,
    AUDI,
    BMW,
    MERCEDES,
    TATA
}


abstract class Vehicle{

    protected VehicleType vehicleType;
    protected Brand brand;
    protected String licensePlateNo;

    abstract String startEngine();

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getLicensePlateNo() {
        return licensePlateNo;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setLicensePlateNo(String licensePlateNo) {
        this.licensePlateNo = licensePlateNo;
    }
}



class Bike extends Vehicle{

    public Bike(Brand brand,String licenseNumber){
        this.brand = brand;
        this.vehicleType = VehicleType.TWO_WHEELER;
        this.licensePlateNo = licenseNumber;
    }

    @Override
    String startEngine() {
        return "Bike Engine Started";
    }
}


class Car extends Vehicle{

    public Car(Brand brand,String licenseNumber){
        this.brand = brand;
        this.vehicleType = VehicleType.FOUR_WHEELER;
        this.licensePlateNo = licenseNumber;
    }

    @Override
    String startEngine() {
        return "Car Engine Started";
    }
}

class Buggy extends Vehicle{

    public Buggy(Brand brand,String licenseNumber){
        this.brand = brand;
        this.vehicleType = VehicleType.FOUR_WHEELER;
        this.licensePlateNo = licenseNumber;
    }

    @Override
    String startEngine() {
        return "Buggy Engine Started";
    }
}


class Truck extends Vehicle{

    public Truck(Brand brand,String licenseNumber){
        this.brand = brand;
        this.vehicleType = VehicleType.EIGHT_WHEELER;
        this.licensePlateNo = licenseNumber;
    }

    @Override
    String startEngine() {
        return "Truck Engine Started";
    }
}





