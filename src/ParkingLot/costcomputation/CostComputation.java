package ParkingLot.costcomputation;

import ParkingLot.Ticket;
import ParkingLot.pricingstrategy.PricingStrategy;

public class CostComputation {
    private final PricingStrategy pricingStrategy;

    public CostComputation(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public double compute(Ticket ticket) {
        return pricingStrategy.price(ticket);
    }
}
