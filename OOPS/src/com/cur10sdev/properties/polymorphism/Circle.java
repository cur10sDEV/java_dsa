package com.cur10sdev.properties.polymorphism;

public class Circle extends Shapes {
    int radius;

    Circle() {
        this.radius = 1;
    }

    @Override
    public String toString() {
        return "Circle of radius: " + this.radius;
    }

    @Override
    void area() {
        System.out.println(Math.PI * Math.pow(radius,2));;
    }
}
