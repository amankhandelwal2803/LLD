package parkinglot.parkingspotmanager;

import parkinglot.parkingspot.ParkingSpot;
import parkinglot.parkingstrategy.ParkingStrategy;

import java.util.List;

public class TwoWheelerManager extends ParkingSpotManager {

    public TwoWheelerManager(List<ParkingSpot> parkingSpotList, ParkingStrategy parkingStrategy) {
        super(parkingSpotList, parkingStrategy);
    }
}
