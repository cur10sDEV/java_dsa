package com.cur10sdev.staticExample;

public class StaticInnerClass {
    static class Test {
        String name;
        public Test(String name){
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Test a = new Test("Rahul");
        Test b = new Test("Rohan");

        System.out.println(a.name); // Rahul
        System.out.println(b.name); // Rohan
    }
}
