package ParkingLot.parkingspotmanager;

import ParkingLot.parkingspot.ParkingSpot;
import ParkingLot.parkingstrategy.ParkingStrategy;

import java.util.List;

public class FourWheelerManager extends ParkingSpotManager {

    public FourWheelerManager(List<ParkingSpot> parkingSpotList, ParkingStrategy parkingStrategy) {
        super(parkingSpotList, parkingStrategy);
    }
}
