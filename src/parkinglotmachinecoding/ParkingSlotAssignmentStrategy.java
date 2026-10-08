package parkinglotmachinecoding;

import java.util.List;

interface ParkingSlotAssignmentStrategy {

    ParkingSlot assignSlot(List<Floor> floors, VehicleType vehicleType);
}