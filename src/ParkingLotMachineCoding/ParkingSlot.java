package ParkingLotMachineCoding;

public class ParkingSlot {

    private final int parkingSlotNumber;
    private final VehicleType parkingSlotType;
    private Vehicle currentParkedVehicle;

    public ParkingSlot(int parkingSlotNumber, VehicleType parkingSlotType) {
        this.parkingSlotNumber = parkingSlotNumber;
        this.parkingSlotType = parkingSlotType;
    }

    public boolean isSlotAvailable() {
        return currentParkedVehicle == null;
    }

    public boolean canPark() {
        return isSlotAvailable() && parkingSlotType == currentParkedVehicle.getVehicleType();
    }

    public void park(Vehicle vehicle) {
        this.currentParkedVehicle = vehicle;
    }

    public Vehicle unpark() {
        Vehicle vehicle = this.currentParkedVehicle;
        this.currentParkedVehicle = null;
        return vehicle;
    }

    public int getParkingSlotNumber() {
        return parkingSlotNumber;
    }

    public VehicleType getParkingSlotType() {
        return parkingSlotType;
    }

    public Vehicle getCurrentParkedVehicle() {
        return currentParkedVehicle;
    }
}
