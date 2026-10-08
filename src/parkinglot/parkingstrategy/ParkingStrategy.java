package parkinglot.parkingstrategy;

import parkinglot.parkingspot.ParkingSpot;

import java.util.List;

public interface ParkingStrategy {

    ParkingSpot findSpace(List<ParkingSpot> parkingSpots);
}
