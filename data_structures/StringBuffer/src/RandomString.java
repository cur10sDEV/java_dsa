public class RandomString {
    static String generate(int size) {
        StringBuffer sb = new StringBuffer(size);
        for (int i = 0; i < size; i++) {
            int randomChar = (int) Math.floor(97 + (Math.random() * 26));
            char ch = (char) randomChar;
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(generate(28));
    }
}
