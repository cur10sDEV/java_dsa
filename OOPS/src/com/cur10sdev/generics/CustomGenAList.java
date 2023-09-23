package com.cur10sdev.generics;

import java.util.Arrays;

//public class CustomGenAList<T extends Number> { // wildcard - now will only allow Number class and its subclasses - Integer, Float,etc
public class CustomGenAList<T> {
    private Object[] data;
    final private int DEFAULT_SIZE = 10;
    private int size = 0; // acting also as index

    public CustomGenAList() {
        this.data = new Object[DEFAULT_SIZE];
    }

    public void add(T value) {
        if (isFull()) {
            resize();
        }
        data[size++] = value;
    }

    private void resize() {
        Object[] temp = new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    private boolean isFull() {
        return size == data.length;
    }

    public T remove() {
        T removed = (T) data[--size];
        return removed;
    }

    public T get(int index) {
        return (T) data[index];
    }

    public void set(int index, T value) {
        data[index] = value;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        Object[] arr = new Object[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (T) data[i];
        }
        return Arrays.toString(arr);
    }

    public static void main(String[] args) {
        CustomGenAList<Integer> list = new CustomGenAList<>();
        for (int i = 0; i < 11; i++) {
            list.add(i * 5);
        }
        System.out.println(list.sumOfList(list));
        System.out.println(list);
    }

    public void addNumbers(CustomGenAList<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }

    public double sumOfList(CustomGenAList<? extends Number> list) {
        double s = 0.0;
        for (int i = 0; i < list.size(); i++) {
            s += list.get(i).doubleValue();
        }
        return s;
    }
}
