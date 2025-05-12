package StrategyPattern;

import StrategyPattern.strategy.DriveStrategy;

public class Vehicle {

    DriveStrategy obj;

    // constructor injection
    Vehicle(DriveStrategy obj) {
        this.obj = obj;
    }

    void drive() {
        obj.drive();
    }
}
