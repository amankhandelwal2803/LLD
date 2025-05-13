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
        if (manager.parkVehicle(vehicle)) {
            ParkingSpot spot = manager.findParkingSpace(); // Returns the spot where the vehicle is parked
            return new Ticket(LocalDateTime.now(), vehicle, spot);
        }
        return null;
    }
}
