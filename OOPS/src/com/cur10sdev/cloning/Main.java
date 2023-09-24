package com.cur10sdev.cloning;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Human me = new Human("jonas", 28);
        Human twin = (Human) me.deepClone();
        twin.arr[0] = 100;
        System.out.println(Arrays.toString(me.arr));
    }
}
