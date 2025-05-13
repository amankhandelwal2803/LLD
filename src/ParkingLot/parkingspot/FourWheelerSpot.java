package ParkingLot.parkingspot;

import ParkingLot.vehicle.Vehicle;
import ParkingLot.vehicle.VehicleType;

public class FourWheelerSpot extends ParkingSpot {

    public FourWheelerSpot(int price, Vehicle vehicle, boolean isEmpty, int id) {
        super(price, vehicle, isEmpty, id);
    }

    @Override
    public VehicleType getSpotType() {
        return VehicleType.FOUR_WHEELER;
    }
}
