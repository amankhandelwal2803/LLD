package ParkingLotMachineCoding;

public class Vehicle {

    private final VehicleType vehicleType;
    private final String vehicleRegistrationNumber;
    private final String vehicleColor;

    public Vehicle(VehicleType vehicleType, String vehicleRegistrationNumber, String vehicleColor) {
        this.vehicleType = vehicleType;
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
        this.vehicleColor = vehicleColor;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getVehicleRegistrationNumber() {
        return vehicleRegistrationNumber;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }
}
