package ParkingLot.parkingspot;

import ParkingLot.vehicle.Vehicle;
import ParkingLot.vehicle.VehicleType;

public class TwoWheelerSpot extends ParkingSpot {

    public TwoWheelerSpot(int price, Vehicle vehicle, boolean isEmpty, int id) {
        super(price, vehicle, isEmpty, id);
    }

    @Override
    public VehicleType getSpotType() {
        return VehicleType.TWO_WHEELER;
    }
}
