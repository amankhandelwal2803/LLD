package ParkingLot.payment;

import java.time.format.DateTimeFormatter;

public class OnlinePayment extends Payment {

    public OnlinePayment(double amount) {
        super(amount);
    }

    @Override
    public void displayPaymentDetails() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedTime = paymentTime.format(formatter);
        System.out.println("Paid ₹" + amount + " online at " + formattedTime);
    }
}
