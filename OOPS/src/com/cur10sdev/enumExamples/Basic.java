package com.cur10sdev.enumExamples;

public class Basic {
    enum Week implements A {
        Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;
        // overall type is Week

        // constructor
        Week() {
            System.out.println("Constructor is called for " + this);
        }

        @Override
        public void hello() {
            System.out.println("Hey!");
        }
    }

    public static void main(String[] args) {
        Week week = Week.Monday;
        System.out.println(week.ordinal()); // returns the index

        week.hello();

        for (Week day : Week.values()) {
            System.out.println(day);
        }
    }
}
