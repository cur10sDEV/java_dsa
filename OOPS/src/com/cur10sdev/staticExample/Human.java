package com.cur10sdev.staticExample;

public class Human {
    int age;
    String name;
    int salary;
    boolean married;
    static long population;

    public Human(int age, String name, int salary, boolean married) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.married = married;
        // "this" keyword instead of classname also works
        // but the convention says to use the classname instead
        // because the static variables are apart from the instance variable
        Human.population += 1;
    }
}
