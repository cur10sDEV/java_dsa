import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String str = "abcd";
        System.out.println(permutations("",str));
        System.out.println(countPermutations("",str));
    }

    static ArrayList<String> permutations(String p, String unp) {
        ArrayList<String> ans = new ArrayList<>();
        if (unp.isEmpty()) {
            ans.add(p);
            return ans;
        }
        for (int i = 0; i <= p.length(); i++) {
            String newP = p.substring(0,i) + unp.charAt(0) + p.substring(i);
            ans.addAll(permutations(newP,unp.substring(1)));
        }
        return ans;
    }

    static int countPermutations(String p, String unp) {
        int ans = 0;
        if (unp.isEmpty()) {
            return 1;
        }
        for (int i = 0; i <= p.length(); i++) {
            String newP = p.substring(0, i) + unp.charAt(0) + p.substring(i);
            ans += countPermutations(newP,unp.substring(1));
        }
        return ans;
    }
}