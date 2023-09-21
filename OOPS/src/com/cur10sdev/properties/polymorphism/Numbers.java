package com.cur10sdev.properties.polymorphism;

// compile time polymorphism
public class Numbers {

    void sum() {
        System.out.println(0);
    }

    void sum(int a, int b) {
        System.out.println(a+b);
    }

    // variable arguments
    void sum(int... nums) {
        int total = 0;
        for (int num:
             nums) {
            total += num;
        }
        System.out.println(total);
    }

    public static void main(String[] args) {
        Numbers num = new Numbers();
        num.sum();
        num.sum(1,2);
        num.sum(1,2,1,2,1,2);
    }
}
