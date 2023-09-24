package com.cur10sdev.exceptionHandling;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(divide(5, 0));
        } // union type
        catch (MyException | ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Normal Exception");
        } finally {
            System.out.println("This will always execute");
        }
    }

    private static int divide(int a, int b) throws MyException {
        if (b == 0) {
            throw new MyException("Cannot be divided by Zero");
        }
        return a / b;
    }
}
