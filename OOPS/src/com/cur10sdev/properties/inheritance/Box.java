package com.cur10sdev.properties.inheritance;

public class Box {
    double h;
    double w;
    double l;

    Box() {
        this.l = -1;
        this.w = -1;
        this.h = -1;
    }

    Box(double l, double w, double h) {
        this.l = l;
        this.w = w;
        this.h = h;
    }

    public void information() {
        System.out.println("L: " + this.l);
        System.out.println("W: " + this.w);
        System.out.println("H: " + this.h);
    }
}
