package ParkingLot.pricingstrategy;

import ParkingLot.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public class MinuteBasedPricingStrategy implements PricingStrategy {

    @Override
    public double price(Ticket ticket) {
        long hours = Duration.between(ticket.entryTime, LocalDateTime.now()).toMinutes();
        return hours * ticket.parkingSpot.getPrice();
    }
}
