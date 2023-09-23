package com.cur10sdev.abstractDemo;

public class Main {
    public static void main(String[] args) {
        Parent.greet();
        Son son = new Son(35, 56);
        son.career("Coder");
        son.partner("Netflix", 21);
    }
}
