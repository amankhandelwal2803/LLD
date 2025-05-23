package ParkingLotMachineCoding;

import java.util.Scanner;

public class ParkingLotApp {

    private static ParkingLotService parkingLotService;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("exit")) break;
            processCommand(line);
        }
    }

    private static void processCommand(String line) {
        String[] parts = line.split(" ");
        switch (parts[0]) {
            case "create_parking_lot":
                parkingLotService = new ParkingLotService(parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
                System.out.println("Created parking lot with " + parts[2] + " floors and " + parts[3] + " slots per floor");
                break;
            case "park_vehicle":
                parkingLotService.parkVehicle(new Vehicle(VehicleType.valueOf(parts[1]), parts[2], parts[3]));
                break;
            case "unpark_vehicle":
                parkingLotService.unparkVehicle(parts[1]);
                break;
            case "display":
                VehicleType type = VehicleType.valueOf(parts[2]);
                switch (parts[1]) {
                    case "free_count":
                        parkingLotService.displayFreeCount(type);
                        break;
                    case "free_slots":
                        parkingLotService.displayFreeSlots(type);
                        break;
                    case "occupied_slots":
                        parkingLotService.displayOccupiedSlots(type);
                        break;
                }
                break;
        }
    }
}
