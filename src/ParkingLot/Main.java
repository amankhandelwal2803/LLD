package ParkingLot;

import ParkingLot.parkingspot.FourWheelerSpot;
import ParkingLot.parkingspot.ParkingSpot;
import ParkingLot.parkingspot.TwoWheelerSpot;
import ParkingLot.parkingspotmanager.ParkingSpotManager;
import ParkingLot.parkingstrategy.DefaultParking;
import ParkingLot.parkingstrategy.NearToEntranceParking;
import ParkingLot.payment.CashPayment;
import ParkingLot.payment.OnlinePayment;
import ParkingLot.payment.Payment;
import ParkingLot.pricingstrategy.HourlyBasedPricingStrategy;
import ParkingLot.vehicle.Vehicle;
import ParkingLot.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Setup parking spots
        List<ParkingSpot> twoWheelerSpots = new ArrayList<>();
        List<ParkingSpot> fourWheelerSpots = new ArrayList<>();

        // Adding two-wheeler and four-wheeler spots
        for (int i = 0; i < 3; i++) twoWheelerSpots.add(new TwoWheelerSpot(10, null, true, i));
        for (int i = 0; i < 3; i++) fourWheelerSpots.add(new FourWheelerSpot(20, null, true, i + 100));

        // Create ParkingSpotManagers with strategies
        ParkingSpotManager twoManager = new ParkingSpotManager(twoWheelerSpots, new DefaultParking());
        ParkingSpotManager fourManager = new ParkingSpotManager(fourWheelerSpots, new NearToEntranceParking());

        // Map managers by vehicle type
        Map<VehicleType, ParkingSpotManager> map = new HashMap<>();
        map.put(VehicleType.TWO_WHEELER, twoManager);
        map.put(VehicleType.FOUR_WHEELER, fourManager);

        ParkingSpotManagerFactory managerFactory = new ParkingSpotManagerFactory(map);
        CostComputationFactory costFactory = new CostComputationFactory(new HourlyBasedPricingStrategy());

        // Singleton ParkingSystem
        ParkingSystem parkingSystem = ParkingSystem.getInstance(managerFactory, costFactory);

        // --- Simulate Two-Wheeler Entry and Exit ---
        Vehicle bike = new Vehicle(1, VehicleType.TWO_WHEELER);
        Ticket bikeTicket = parkingSystem.vehicleEntry(bike);

        try {
            Thread.sleep(3000); // simulate time spent
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Payment bikePayment = new CashPayment(10); // sufficient amount
        parkingSystem.vehicleExit(bikeTicket, bikePayment);

        // --- Simulate Four-Wheeler Entry and Exit ---
        Vehicle car = new Vehicle(2, VehicleType.FOUR_WHEELER);
        Ticket carTicket = parkingSystem.vehicleEntry(car);

        try {
            Thread.sleep(4000); // simulate time spent
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Payment carPayment = new OnlinePayment(10);
        parkingSystem.vehicleExit(carTicket, carPayment);
    }
}