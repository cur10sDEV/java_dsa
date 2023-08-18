import java.util.ArrayList;

public class Subset {
    public static void main(String[] args) {
        String str = "abcd";
        ArrayList<String> ans = new ArrayList<>();
        System.out.println(findAllSubsetsWithAscii("", str));
        System.out.println(ans);
    }

    // here p - processed and unp - unprocessed
    static ArrayList<String> findAllSubsets(String p, String unp) {
        ArrayList<String> ans = new ArrayList<>();
        if (unp.isEmpty()) {
            ans.add(p);
            return ans;
        }
        ans.addAll(findAllSubsets(p + unp.charAt(0),unp.substring(1)));
        ans.addAll(findAllSubsets(p, unp.substring(1)));
        return ans;
    }

    // here p - processed and unp - unprocessed
    static void findAllSubsets(String p, String unp,ArrayList<String> ans) {
        if (unp.isEmpty()) {
            ans.add(p);
            return;
        }
        findAllSubsets(p + unp.charAt(0),unp.substring(1),ans);
        findAllSubsets(p, unp.substring(1),ans);
    }

    // here p - processed and unp - unprocessed
    // also contains ascii values of characters
    static ArrayList<String> findAllSubsetsWithAscii(String p, String unp) {
        ArrayList<String> ans = new ArrayList<>();
        if (unp.isEmpty()) {
            ans.add(p);
            return ans;
        }
        ans.addAll(findAllSubsetsWithAscii(p + unp.charAt(0),unp.substring(1)));
        ans.addAll(findAllSubsetsWithAscii(p + (unp.charAt(0)+0),unp.substring(1)));
        ans.addAll(findAllSubsetsWithAscii(p, unp.substring(1)));
        return ans;
    }
}
