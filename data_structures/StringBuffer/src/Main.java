public class Main {
    public static void main(String[] args) {
        // constructor 1 - empty string buffer
        StringBuffer sb = new StringBuffer();
        sb.append("hello");

        sb.insert(4,"oo");

        sb.replace(0,1, "H");

        sb.delete(4,6);

        // sb.reverse();

        // constructor 2 - with initial value
        StringBuffer sb2 = new StringBuffer("World!");

        // constructor 3 - defined capacity
        StringBuffer sb3 = new StringBuffer(30);
        sb3.append(" ");

        String str = sb.append(sb3).append(sb2).toString();
        System.out.println(str);
    }
}