import java.util.ArrayList;

public class NumberPad {
    public static void main(String[] args) {
        System.out.println(pad("", "23"));
    }

    static ArrayList<String> pad(String p, String unp) {
        ArrayList<String> ans = new ArrayList<>();
        if (unp.isEmpty()) {
            ans.add(p);
            return ans;
        }
        int digit = unp.charAt(0) - '1';
        for (int i = (digit-1)*3; i < digit * 3; i++) {
            char ch = (char)('a' + i);
            ans.addAll(pad(p+ch,unp.substring(1)));
        }
        return ans;
    }
}