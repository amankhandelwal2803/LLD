package ParkingLot.vehicle;

public class Vehicle {
    private final int vehicleNumber;
    private final VehicleType vehicleType;

    public Vehicle(int vehicleNumber, VehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
