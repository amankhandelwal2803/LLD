package parkinglot.parkingspotmanager;

import parkinglot.parkingspot.ParkingSpot;
import parkinglot.parkingstrategy.ParkingStrategy;
import parkinglot.vehicle.Vehicle;

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

    public synchronized ParkingSpot parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = findParkingSpace();
        if (spot != null) {
            spot.parkVehicle(vehicle);
        }
        return spot;
    }

    public synchronized void removeVehicle(ParkingSpot spot) {
        spot.removeVehicle();
    }
}
