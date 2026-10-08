package parkinglot.parkingspotmanager;

import parkinglot.parkingspot.ParkingSpot;
import parkinglot.parkingstrategy.ParkingStrategy;

import java.util.List;

public class FourWheelerManager extends ParkingSpotManager {

    public FourWheelerManager(List<ParkingSpot> parkingSpotList, ParkingStrategy parkingStrategy) {
        super(parkingSpotList, parkingStrategy);
    }
}
