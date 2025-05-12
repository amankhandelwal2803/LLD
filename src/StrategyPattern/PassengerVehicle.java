package StrategyPattern;

import StrategyPattern.strategy.NormalDriveStrategy;

public class PassengerVehicle extends Vehicle {

    PassengerVehicle() {
        super(new NormalDriveStrategy());
    }
}
