package ParkingLot.parkingstrategy;

import ParkingLot.parkingspot.ParkingSpot;

import java.util.List;

public interface ParkingStrategy {

    ParkingSpot findSpace(List<ParkingSpot> parkingSpots);
}
