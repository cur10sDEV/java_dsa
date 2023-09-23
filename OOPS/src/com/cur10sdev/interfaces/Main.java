package com.cur10sdev.interfaces;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
//        car.start();

        CustomCar car2 = new CustomCar();
        car2.start();
        car2.startMedia();
        car2.upgradeEngine();
        car2.start();
        car2.brake();
        car2.stop();
    }
}