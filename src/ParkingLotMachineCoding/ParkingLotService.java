package ParkingLotMachineCoding;

import java.util.*;

public class ParkingLotService {

    private final String parkingLotId;
    private final List<Floor> floors;
    private final Map<String, Ticket> activeTickets;

    public ParkingLotService(String parkingLotId, int numberOfFloors, int slotsPerFloor) {
        this.parkingLotId = parkingLotId;
        this.floors = new ArrayList<>();
        this.activeTickets = new HashMap<>();

        for (int i = 1; i <= numberOfFloors; i++) {
            floors.add(new Floor(i, slotsPerFloor));
        }
    }

    public void parkVehicle(Vehicle vehicle) {
        for (Floor floor : floors) {
            Optional<ParkingSlot> slotOptional = floor.findAvailableSlot(vehicle.getVehicleType());
            if (slotOptional.isPresent()) {
                ParkingSlot slot = slotOptional.get();
                slot.park(vehicle);
                Ticket ticket = new Ticket(parkingLotId, floor.getFloorNumber(), slot.getParkingSlotNumber(), vehicle);
                activeTickets.put(ticket.getTicketId(), ticket);
                System.out.println("Parked vehicle. Ticket ID: " + ticket.getTicketId());
                return;
            }
        }
        System.out.println("Parking Lot Full");
    }

    public void unparkVehicle(String ticketId) {
        Ticket ticket = activeTickets.remove(ticketId);
        if (ticket == null) {
            System.out.println("Invalid Ticket");
            return;
        }
        Floor floor = floors.get(ticket.getFloorNumber() - 1);
        ParkingSlot slot = floor.getSlots().get(ticket.getParkingSlotNumber() - 1);
        Vehicle vehicle = slot.unpark();
        System.out.println("Unparked vehicle with Registration Number: "
                + vehicle.getVehicleRegistrationNumber()
                + " and Color: " + vehicle.getVehicleColor());
    }

    public void displayFreeCount(VehicleType vehicleType) {
        for (Floor floor : floors) {
            long count = floor.getSlots().stream()
                    .filter(slot -> slot.getParkingSlotType() == vehicleType && slot.isSlotAvailable())
                    .count();
            System.out.println("No. of free slots for " + vehicleType + " on Floor " + floor.getFloorNumber() + ": " + count);
        }
    }

    public void displayFreeSlots(VehicleType vehicleType) {
        for (Floor floor : floors) {
            List<Integer> freeSlots = floor.getSlotNumbersByTypeAndStatus(vehicleType, true);
            System.out.println("Free slots for " + vehicleType + " on Floor "
                    + floor.getFloorNumber() + ": "
                    + String.join(",", freeSlots.stream().map(String::valueOf).toArray(String[]::new)));
        }
    }

    public void displayOccupiedSlots(VehicleType vehicleType) {
        for (Floor floor : floors) {
            List<Integer> occupiedSlots = floor.getSlotNumbersByTypeAndStatus(vehicleType, false);
            System.out.println("Occupied slots for " + vehicleType + " on Floor "
                    + floor.getFloorNumber() + ": "
                    + String.join(",", occupiedSlots.stream().map(String::valueOf).toArray(String[]::new)));
        }
    }
}
