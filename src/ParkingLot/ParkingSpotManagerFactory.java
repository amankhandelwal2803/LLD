package ParkingLot;

import ParkingLot.parkingspotmanager.ParkingSpotManager;
import ParkingLot.vehicle.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class ParkingSpotManagerFactory {
    private final Map<VehicleType, ParkingSpotManager> managerMap = new HashMap<>();

    public ParkingSpotManagerFactory(Map<VehicleType, ParkingSpotManager> managerMap) {
        this.managerMap.putAll(managerMap);
    }

    public ParkingSpotManager getManager(VehicleType type) {
        return managerMap.get(type);
    }
}
