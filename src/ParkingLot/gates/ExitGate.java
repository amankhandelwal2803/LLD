package ParkingLot.gates;

import ParkingLot.CostComputationFactory;
import ParkingLot.ParkingSpotManagerFactory;
import ParkingLot.Ticket;
import ParkingLot.parkingspotmanager.ParkingSpotManager;
import ParkingLot.payment.Payment;

public class ExitGate {
    private final CostComputationFactory costComputationFactory;
    private final ParkingSpotManagerFactory managerFactory;

    public ExitGate(CostComputationFactory costComputationFactory, ParkingSpotManagerFactory managerFactory) {
        this.costComputationFactory = costComputationFactory;
        this.managerFactory = managerFactory;
    }

    public double processExit(Ticket ticket, Payment payment) {
        double price = costComputationFactory.getCostComputation(ticket.vehicle.getVehicleType()).compute(ticket);
        if (payment.getAmount() < price) {
            throw new IllegalArgumentException("Insufficient payment. Required: " + price);
        }
        payment.displayPaymentDetails();

        ParkingSpotManager manager = managerFactory.getManager(ticket.vehicle.getVehicleType());
        manager.removeVehicle(ticket.parkingSpot);
        return price;
    }
}
