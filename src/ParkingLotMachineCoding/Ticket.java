package ParkingLotMachineCoding;

public class Ticket {

    private final String ticketId;
    private final Vehicle vehicle;
    private final int floorNumber;
    private final int parkingSlotNumber;

    public Ticket(String lotId, int floorNumber, int parkingSlotNumber, Vehicle vehicle) {
        this.ticketId = lotId + "_" + floorNumber + "_" + parkingSlotNumber;
        this.floorNumber = floorNumber;
        this.parkingSlotNumber = parkingSlotNumber;
        this.vehicle = vehicle;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getParkingSlotNumber() {
        return parkingSlotNumber;
    }
}
