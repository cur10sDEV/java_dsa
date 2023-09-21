package com.cur10sdev.properties.inheritance;

public class BoxPrice extends BoxWeight {
    double cost;

    BoxPrice() {
        super();
        this.cost = -1;
    }

    BoxPrice(double cost) {
        super();
        this.cost = cost;
    }

    BoxPrice(double l,double w,double h,double wt,double cost) {
        super(l,w,h,wt);
        this.cost = cost;
    }

    public void information() {
        super.information();
        System.out.println("Cost: " + this.cost);
    }
}
