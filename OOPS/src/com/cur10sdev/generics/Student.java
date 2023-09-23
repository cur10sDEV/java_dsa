package com.cur10sdev.generics;

public class Student implements Comparable<Student> {
    int rollNo;
    float marks;

    @Override
    public String toString() {
        return rollNo + " " + marks;
    }

    @Override
    public int compareTo(Student o) {
        int diff = (int) (this.marks - o.marks);
        return diff;
    }

    public Student(int rollNo, float marks) {
        this.rollNo = rollNo;
        this.marks = marks;
    }

}
