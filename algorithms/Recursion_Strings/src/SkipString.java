public class SkipString {
    public static void main(String[] args) {
        String str = "jfapplejfalkdasappkffapples";
        String toSkip = "app";
        String toNotSkip = "apple";
        System.out.println(skipThatIfNotThat(str, toSkip,toNotSkip));
    }

    static String skipString(String str, String toSkip) {
        String ans = "";
        if (str.isEmpty()) {
            return ans;
        }
        if (str.startsWith(toSkip)) {
            return skipString(str.substring(toSkip.length()), toSkip);
        } else {
            return str.charAt(0) + skipString(str.substring(1), toSkip);
        }
    }

    static String skipThatIfNotThat(String str, String toSkip, String toNotSkip) {
        String ans = "";
        if (str.isEmpty()) {
            return ans;
        }
        if (str.startsWith(toSkip) && !str.startsWith(toNotSkip)) {
            return skipThatIfNotThat(str.substring(toSkip.length()), toSkip, toNotSkip);
        } else {
            return str.charAt(0) + skipThatIfNotThat(str.substring(1), toSkip, toNotSkip);
        }
    }
}
