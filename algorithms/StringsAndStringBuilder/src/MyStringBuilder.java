public class MyStringBuilder {
    public static void main(String[] args) {
        // In this code if we use normal String class on each iteration it will create a new object with no reference
        // variable so too much space waste
        // space complexity O(n**n)
        String alphabets = "";
        for (int i = 0; i < 26; i++) {
            char ch = (char)('a' + i);
            alphabets += ch;
        }
        System.out.println(alphabets);

        // string builder doesn't create a new object and only appends the changes to the same object
        // thus its space complexity is O(n)
        StringBuilder series = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a'+i);
            series.append(ch);
        }
        System.out.println(series);
    }
}
