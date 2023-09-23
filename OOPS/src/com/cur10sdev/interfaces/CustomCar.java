package com.cur10sdev.interfaces;

public class CustomCar {
    private Engine engine;
    final private Media player = new MediaPlayer();
    final private Brake brake = new PowerBrake();

    public CustomCar() {
        this.engine = new PowerEngine();
    }

    public CustomCar(Engine engine) {
        this.engine = engine;
    }

    public void upgradeEngine() {
        this.engine = new ElectricEngine();
    }

    public void start() {
        engine.start();
    }

    public void stop() {
        engine.stop();
    }

    public void acc() {
        engine.acc();
    }

    public void startMedia() {
        player.start();
    }

    public void stopMedia() {
        player.stop();
    }

    public void brake() {
        brake.brake();
    }
}
