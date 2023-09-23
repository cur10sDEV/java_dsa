package com.cur10sdev.generics;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Student me = new Student(12, 83.87f);
        Student you = new Student(3, 61.02f);
        Student he = new Student(5, 74.55f);
        Student she = new Student(7, 96.13f);

        Student[] list = {me, you, he, she};
        System.out.println(Arrays.toString(list));
        // lambda functions - arrow functions of js
        Arrays.sort(list, (a,b) -> -(int)(a.marks - b.marks));
        System.out.println(Arrays.toString(list));


//        if (me.compareTo(you) < 0) {
//            System.out.println("You're better than me");
//        }
    }
}
