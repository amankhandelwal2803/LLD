package parkinglot;

import parkinglot.costcomputation.CostComputation;
import parkinglot.costcomputation.FourWheelerCostComputation;
import parkinglot.costcomputation.TwoWheelerCostComputation;
import parkinglot.pricingstrategy.PricingStrategy;
import parkinglot.vehicle.VehicleType;

public class CostComputationFactory {
    private final PricingStrategy pricingStrategy;

    public CostComputationFactory(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public CostComputation getCostComputation(VehicleType vehicleType) {
        switch (vehicleType) {
            case TWO_WHEELER -> {
                return new TwoWheelerCostComputation(pricingStrategy);
            }
            case FOUR_WHEELER -> {
                return new FourWheelerCostComputation(pricingStrategy);
            }
            default -> {
                return null;
            }
        }
    }
}
