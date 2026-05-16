package creationalPatterns.prototypePattern;

public class PrototypePatternTest {

    static void main() {

    }

}


class Vehicle{
    private String plateNumber;
    private String vehicleType;


    public Vehicle(String plateNumber, String vehicleType) {
        this.plateNumber = plateNumber;
        this.vehicleType = vehicleType;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }


    /**
     * Copy Constructor
     * @param vehicle
     */
    public Vehicle(Vehicle vehicle){
        this.vehicleType = vehicle.getVehicleType();
        this.plateNumber = vehicle.getPlateNumber();
    }


}




