import java.util.ArrayList;

public class Dice {
    public static void main(String[] args) {
        System.out.println(findAllCombinations("",4));
    }

    // returns all the combinations of the dice values(can be thrown multiple times) that can make the given num
    static ArrayList<String> findAllCombinations(String p, int num) {
        ArrayList<String> ans = new ArrayList<>();
        if (num == 0) {
            ans.add(p);
            return ans;
        }
        for (int i = 1; i <= 6 && i <= num; i++) {
            ans.addAll(findAllCombinations(p+i,num-i));
        }
        return ans;
    }
}
