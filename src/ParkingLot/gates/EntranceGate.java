package ParkingLot.gates;

import ParkingLot.ParkingSpotManagerFactory;
import ParkingLot.Ticket;
import ParkingLot.parkingspot.ParkingSpot;
import ParkingLot.parkingspotmanager.ParkingSpotManager;
import ParkingLot.vehicle.Vehicle;

import java.time.LocalDateTime;

public class EntranceGate {
    private final ParkingSpotManagerFactory managerFactory;

    public EntranceGate(ParkingSpotManagerFactory factory) {
        this.managerFactory = factory;
    }

    public Ticket processVehicle(Vehicle vehicle) {
        ParkingSpotManager manager = managerFactory.getManager(vehicle.getVehicleType());
        ParkingSpot parkingSpot = manager.parkVehicle(vehicle);
        if (parkingSpot != null) {
            return new Ticket(LocalDateTime.now(), vehicle, parkingSpot);
        }
        return null;
    }
}
