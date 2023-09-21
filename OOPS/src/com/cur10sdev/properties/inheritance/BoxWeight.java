package com.cur10sdev.properties.inheritance;

public class BoxWeight extends Box {
    double wt;

    BoxWeight() {
        super();
        this.wt = -1;
    }

    BoxWeight(double wt) {
        super();
        this.wt = wt;
    }

    BoxWeight(double l, double w, double h, double wt) {
        super(l, w, h);
        this.wt = wt;
    }

    public void information() {
        super.information();
        System.out.println("WT: " + this.wt);
    }
}
