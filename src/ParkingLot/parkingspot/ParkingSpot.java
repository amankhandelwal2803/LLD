package ParkingLot.parkingspot;

import ParkingLot.vehicle.Vehicle;
import ParkingLot.vehicle.VehicleType;

public abstract class ParkingSpot {
    protected final int id;
    protected final int price;
    protected boolean isEmpty;
    protected Vehicle vehicle;

    public ParkingSpot(int price, Vehicle vehicle, boolean isEmpty, int id) {
        this.price = price;
        this.vehicle = vehicle;
        this.isEmpty = isEmpty;
        this.id = id;
    }

    public synchronized void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isEmpty = false;
    }

    public synchronized void removeVehicle() {
        this.vehicle = null;
        this.isEmpty = true;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public int getPrice() {
        return price;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getId() {
        return id;
    }

    // Abstract method to specify if the spot is for a two-wheeler or four-wheeler
    public abstract VehicleType getSpotType();
}