package ParkingLotMachineCoding;

import java.util.List;
import java.util.Optional;

class NearestFirstParkingSlotStrategy implements ParkingSlotAssignmentStrategy {

    @Override
    public ParkingSlot assignSlot(List<Floor> floors, VehicleType vehicleType) {
        for (Floor floor : floors) {
            Optional<ParkingSlot> slot = floor.findAvailableSlot(vehicleType);
            if (slot.isPresent()) {
                return slot.get();
            }
        }
        return null;
    }
}
