import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = new int[]{45, 13, 64, 78, 13, 1, -56, 89,13};
        ArrayList<Integer> ans = new ArrayList<>();
        System.out.println(findAllIndexes(arr, 13,0));
    }

    // returns true/false whether the element exists in the array or not
    static boolean find(int[] arr, int target, int i) {
        i = Math.max(i,0);
        if (i >= arr.length) return false;
        return arr[i] == target || find(arr, target, i + 1);
    }

    // returns the index of the element or -1 if not found in the array
    static int findIndex(int[] arr, int target, int i) {
        i = Math.max(i, 0);
        if (i >= arr.length) return -1;
        if (arr[i] == target) return i;
        return findIndex(arr, target, i + 1);
    }

    // returns the last occurence(index) of an element in the array
    static int findIndexLast(int[] arr, int target, int i) {
        i = Math.min(i,arr.length-1);
        if (i < 0) return i;
        if (arr[i] == target) return i;
        return findIndexLast(arr,target,i-1);
    }

    // returns the arraylist which contains indexes(all the occurrences) of an element in the array
    static ArrayList<Integer> findAllIndexes(int[] arr, int target, ArrayList<Integer> ans, int i) {
        i = Math.max(i,0);
        if (i >= arr.length) return ans;
        if (arr[i] == target) ans.add(i);
        return findAllIndexes(arr,target,ans,i+1);
    }

    static ArrayList<Integer> findAllIndexes(int[] arr, int target, int i) {
        ArrayList<Integer> list = new ArrayList<>();
        if (i >= arr.length) return list;
        if (arr[i] == target) list.add(i);
        list.addAll(findAllIndexes(arr,target,i+1));
        return list;
    }
}
