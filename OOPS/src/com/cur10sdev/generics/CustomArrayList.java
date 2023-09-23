package com.cur10sdev.generics;

import java.util.Arrays;

public class CustomArrayList {
    private int[] data;
    final private int DEFAULT_SIZE = 10;
    private int size = 0;

    public CustomArrayList() {
        this.data = new int[DEFAULT_SIZE];
    }

    public void add(int num) {
        if (this.isFull()) {
            this.resize();
        }
        this.data[this.size++] = num;
    }

    private void resize() {
        int[] temp = new int[this.data.length * 2];
        for (int i = 0; i < this.data.length; i++) {
            temp[i] = this.data[i];
        }
        this.data = temp;
    }

    private boolean isFull() {
        return this.data.length == this.size;
    }

    public int remove(int index) {
        int removed = this.data[--size];
        return removed;
    }

    public int get(int index) {
        return this.data[index];
    }

    public int size() {
        return this.size;
    }

    public void set(int index, int value) {
        this.data[index] = value;
    }

    @Override
    public String toString() {
        return "CustomArrayList{" +
                "data=" + Arrays.toString(data) +
                ", DEFAULT_SIZE=" + DEFAULT_SIZE +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList();
        list.add(5);
        list.add(7);
        list.add(9);
        System.out.println(list);
    }
}
