package ParkingLot.parkingstrategy;

import ParkingLot.parkingspot.ParkingSpot;

import java.util.Comparator;
import java.util.List;

public class NearToEntranceParking implements ParkingStrategy {

    public ParkingSpot findSpace(List<ParkingSpot> parkingSpots) {
        return parkingSpots.stream().filter(ParkingSpot::isEmpty).min(Comparator.comparingInt(ParkingSpot::getId)).orElse(null);
    }
}
