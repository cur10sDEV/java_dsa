package com.cur10sdev.interfaces;

class PowerBrake implements Brake {
    @Override
    public void brake() {
        System.out.println("Power break initialize");
    }
}
