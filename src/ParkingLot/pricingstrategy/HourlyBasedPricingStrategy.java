package ParkingLot.pricingstrategy;

import ParkingLot.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public class HourlyBasedPricingStrategy implements PricingStrategy {
    public double price(Ticket ticket) {
        long hours = Duration.between(ticket.entryTime, LocalDateTime.now()).toHours();
        return Math.max(1, hours) * ticket.parkingSpot.getPrice();
    }
}
