public class SearchInString {
    public static void main(String[] args) {
        String str = "Java is a great language";
        char target = 'a';
        boolean result = search(str, target);
        System.out.println(result);
    }

    // find a char in a string
    static boolean search(String str,char target) {
        // if string is empty
        if (str.length() == 0) return false;

        for (int i = 0; i < str.length(); i++) {
            // if character match with the target return true
            if (target == str.charAt(i)) return true;
        }

        // if not character not found return false
        return false;
    }

    // for each version of the above search function
    static boolean searchTwo(String str, char target) {
        // if string is empty
        if (str.length() == 0) return false;

        for (char ch: str.toCharArray()) {
            // if character match with the target return true
            if (ch == target) return true;
        }

        // if not character not found return false
        return false;
    }
}
