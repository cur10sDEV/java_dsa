public class Main {
    public static void main(String[] args) {
        // creating strings in the string pool inside heap memory
        // means if values are same will point to the same object
        String a = "John";
        String b = "John";
        // check whether these reference variables are pointing to the same object or not
        // by using comparator(comparison operator) i.e., ==
        // it checks both the values and the object reference
        System.out.println(a == b); // will print true

        // ======> Now <======
        // creating strings outside the string pool, so we can have multiple string objects of same value
        // but different objects using "new" keyword
        String c = new String("Jake");
        String d = new String("Jake");
        // check whether these reference variables are pointing to the same object or not
        // by using comparator(comparison operator) i.e., == , it checks both the values and the object reference
        System.out.println(c == d); // will print false
        // but ".equals()" - a string method only checks for the values of the objects
        System.out.println(c.equals(d)); // will print true

        // Note:- Strings are immutable
        // i.e., you cannot modify strings you can only create new ones
        // if you try to change the value of a reference variable
        // it creates a new object and point that reference variable to that newly created object in the heap memory
        String e = "Jenny";
        e = "Jasmine";
        // Note:- if there's no reference variable pointing that object then garbage collection will take care of it
    }
}