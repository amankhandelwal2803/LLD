package ParkingLot.payment;

import java.time.LocalDateTime;

public abstract class Payment {
    protected double amount;
    protected LocalDateTime paymentTime;

    public Payment(double amount) {
        this.amount = amount;
        this.paymentTime = LocalDateTime.now();
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public abstract void displayPaymentDetails();
}
