package com.cur10sdev.properties.encapsulation;

public class SubSubClass extends SubClass {

    public SubSubClass(int num, String name) {
        super(num, name);
    }

    public static void main(String[] args) {
        SubSubClass ss1 = new SubSubClass(11,"subsub");
        int n = ss1.num;
        System.out.println(n);
    }
}
