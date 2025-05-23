package ParkingLotMachineCoding;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Floor {

    private final int floorNumber;
    private final List<ParkingSlot> parkingSlotList;

    public Floor(int floorNumber, int numberOfSlots) {
        this.floorNumber = floorNumber;
        this.parkingSlotList = new ArrayList<>();

        for (int i = 1; i <= numberOfSlots; i++) {
            if (i == 1)
                parkingSlotList.add(new ParkingSlot(i, VehicleType.TRUCK));
            else if (i == 2 || i == 3)
                parkingSlotList.add(new ParkingSlot(i, VehicleType.BIKE));
            else
                parkingSlotList.add(new ParkingSlot(i, VehicleType.CAR));
        }
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<ParkingSlot> getSlots() {
        return parkingSlotList;
    }

    public Optional<ParkingSlot> findAvailableSlot(VehicleType vehicleType) {
        return parkingSlotList.stream()
                .filter(slot -> slot.getParkingSlotType() == vehicleType && slot.isSlotAvailable())
                .findFirst();
    }

    public List<Integer> getSlotNumbersByTypeAndStatus(VehicleType vehicleType, boolean isSlotAvailable) {
        List<Integer> result = new ArrayList<>();
        for (ParkingSlot slot : parkingSlotList) {
            if (slot.getParkingSlotType() == vehicleType && slot.isSlotAvailable() == isSlotAvailable) {
                result.add(slot.getParkingSlotNumber());
            }
        }
        return result;
    }
}
