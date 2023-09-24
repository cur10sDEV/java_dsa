package com.cur10sdev.cloning;

public class Human implements Cloneable{
    String name;
    int age;
    int[] arr;

    public Human(String name, int age) {
        this.age = age;
        this.name = name;
        this.arr = new int[]{1, 2, 3, 4, 5};
    }

    public Object shallowClone() throws CloneNotSupportedException {
        // this is shallow copying
        return super.clone();
    }

    public Object deepClone() throws CloneNotSupportedException {
        // this is deep copying
        Human twin = (Human) super.clone(); // first make a shallow copy
        // make a deep copy
        twin.arr = new int[twin.arr.length];
        for (int i = 0; i < twin.arr.length; i++) {
            twin.arr[i] = this.arr[i];
        }
        return twin;
    }
}
