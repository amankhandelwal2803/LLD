package parkinglot.pricingstrategy;

import parkinglot.Ticket;

public interface PricingStrategy {

    double price(Ticket ticket);
}
