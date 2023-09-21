package com.cur10sdev.properties.encapsulation;

public class SubClass extends A {
    public SubClass(int num, String name) {
        super(num, name);
    }

    public static void main(String[] args) {
        SubClass s1 = new SubClass(10, "Kunal");
        int n = s1.num;
        System.out.println(n);
    }
}
