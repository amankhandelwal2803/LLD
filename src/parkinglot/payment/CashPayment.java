package parkinglot.payment;

import java.time.format.DateTimeFormatter;

public class CashPayment extends Payment {

    public CashPayment(double amount) {
        super(amount);
    }

    @Override
    public void displayPaymentDetails() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedTime = paymentTime.format(formatter);
        System.out.println("Paid ₹" + amount + " in cash at " + formattedTime);
    }
}
