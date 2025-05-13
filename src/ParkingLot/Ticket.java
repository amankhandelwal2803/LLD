package ParkingLot;

import ParkingLot.parkingspot.ParkingSpot;
import ParkingLot.vehicle.Vehicle;

import java.time.LocalDateTime;

public class Ticket {
    public final LocalDateTime entryTime;
    public final Vehicle vehicle;
    public final ParkingSpot parkingSpot;

    public Ticket(LocalDateTime entryTime, Vehicle vehicle, ParkingSpot parkingSpot) {
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
    }
}
