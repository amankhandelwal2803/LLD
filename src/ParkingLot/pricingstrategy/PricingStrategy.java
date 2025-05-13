package ParkingLot.pricingstrategy;

import ParkingLot.Ticket;

public interface PricingStrategy {
    double price(Ticket ticket);
}
