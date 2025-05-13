package ParkingLot.parkingspotmanager;

import ParkingLot.parkingspot.ParkingSpot;
import ParkingLot.parkingstrategy.ParkingStrategy;
import ParkingLot.vehicle.Vehicle;

import java.util.List;

public class ParkingSpotManager {
    protected final List<ParkingSpot> parkingSpots;
    protected final ParkingStrategy parkingStrategy;

    public ParkingSpotManager(List<ParkingSpot> parkingSpots, ParkingStrategy strategy) {
        this.parkingSpots = parkingSpots;
        this.parkingStrategy = strategy;
    }

    public synchronized ParkingSpot findParkingSpace() {
        return parkingStrategy.findSpace(parkingSpots);
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = findParkingSpace();
        if (spot != null) {
            spot.parkVehicle(vehicle);
            return true;
        }
        return false;
    }

    public synchronized void removeVehicle(ParkingSpot spot) {
        spot.removeVehicle();
    }
}
