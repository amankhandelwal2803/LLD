package ParkingLot;

import ParkingLot.gates.EntranceGate;
import ParkingLot.gates.ExitGate;
import ParkingLot.payment.Payment;
import ParkingLot.vehicle.Vehicle;

public class ParkingSystem {

    private static ParkingSystem instance;
    private final ParkingSpotManagerFactory managerFactory;
    private final CostComputationFactory costFactory;
    private final EntranceGate entranceGate;
    private final ExitGate exitGate;

    private ParkingSystem(ParkingSpotManagerFactory managerFactory, CostComputationFactory costFactory) {
        this.managerFactory = managerFactory;
        this.costFactory = costFactory;
        this.entranceGate = new EntranceGate(managerFactory);
        this.exitGate = new ExitGate(costFactory, managerFactory);
    }

    public static synchronized ParkingSystem getInstance(ParkingSpotManagerFactory managerFactory, CostComputationFactory costFactory) {
        if (instance == null) {
            instance = new ParkingSystem(managerFactory, costFactory);
        }
        return instance;
    }

    public Ticket vehicleEntry(Vehicle vehicle) {
        System.out.println("Vehicle entering: " + vehicle.getVehicleNumber() + " of type " + vehicle.getVehicleType());
        Ticket ticket = entranceGate.processVehicle(vehicle);
        if (ticket != null) {
            System.out.println("Vehicle " + vehicle.getVehicleNumber() + " parked at spot " + ticket.parkingSpot.getId());
        } else {
            System.out.println("No available spots for vehicle " + vehicle.getVehicleNumber());
        }
        return ticket;
    }

    public void vehicleExit(Ticket ticket, Payment payment) {
        if (ticket != null) {
            System.out.println("Vehicle exiting: " + ticket.vehicle.getVehicleNumber());
            double cost = exitGate.processExit(ticket, payment);
            System.out.println("Total cost for vehicle " + ticket.vehicle.getVehicleNumber() + ": " + cost);
        } else {
            System.out.println("Invalid ticket. Vehicle couldn't exit.");
        }
    }
}