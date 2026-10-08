package parkinglot.parkingstrategy;

import parkinglot.parkingspot.ParkingSpot;

import java.util.List;

public class DefaultParking implements ParkingStrategy {

    public ParkingSpot findSpace(List<ParkingSpot> parkingSpots) {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.isEmpty()) return spot;
        }
        return null;
    }
}
