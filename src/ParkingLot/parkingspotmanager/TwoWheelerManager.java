package ParkingLot.parkingspotmanager;

import ParkingLot.parkingspot.ParkingSpot;
import ParkingLot.parkingstrategy.ParkingStrategy;

import java.util.List;

public class TwoWheelerManager extends ParkingSpotManager {

    public TwoWheelerManager(List<ParkingSpot> parkingSpotList, ParkingStrategy parkingStrategy) {
        super(parkingSpotList, parkingStrategy);
    }
}
