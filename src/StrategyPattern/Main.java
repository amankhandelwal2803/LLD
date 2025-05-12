package StrategyPattern;

public class Main {

    public static void main(String args[]) {

        Vehicle vehicle1 = new SportsVehicle();
        vehicle1.drive();

        Vehicle vehicle2 = new GoodsVehicle();
        vehicle2.drive();
    }
}
