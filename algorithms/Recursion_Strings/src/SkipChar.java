public class SkipChar {
    public static void main(String[] args) {
        String str = "baccad";
        char ch = 'a';
        System.out.println(skipChar(str,ch));
        System.out.println(skipChar(str,ch,0));
        System.out.println(skipChar("",str,ch));
    }

    static String skipChar(String str, char ch) {
        String ans = "";
        if (str.length() == 0) {
            return ans;
        }
        if (str.charAt(0) != ch) {
            ans += str.charAt(0);
        }
        return ans + skipChar(str.substring(1),ch);
    }

    static String skipChar(String str, char ch, int i) {
        String ans = "";
        if (i >= str.length()) {
            return ans;
        }
        if (str.charAt(i) != ch) {
            ans += str.charAt(i);
        }
        return ans + skipChar(str,ch,i+1);
    }

    // here p - processed and unp - unprocessed
    static String skipChar(String p, String unp, char ch) {
        if (unp.isEmpty()) {
            return p;
        }
        if (unp.charAt(0) != ch) {
            p += unp.charAt(0);
        }
        return skipChar(p,unp.substring(1),ch);
    }
}