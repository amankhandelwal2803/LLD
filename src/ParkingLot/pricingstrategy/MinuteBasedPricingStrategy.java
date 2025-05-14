package ParkingLot.pricingstrategy;

import ParkingLot.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public class MinuteBasedPricingStrategy implements PricingStrategy {

    @Override
    public double price(Ticket ticket) {
        long minutes = Duration.between(ticket.entryTime, LocalDateTime.now()).toMinutes();
        return minutes * ticket.parkingSpot.getPrice();
    }
}
