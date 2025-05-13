package ParkingLot;

import ParkingLot.costcomputation.CostComputation;
import ParkingLot.costcomputation.FourWheelerCostComputation;
import ParkingLot.costcomputation.TwoWheelerCostComputation;
import ParkingLot.pricingstrategy.PricingStrategy;
import ParkingLot.vehicle.VehicleType;

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
