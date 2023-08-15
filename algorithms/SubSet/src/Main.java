import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int[] dupArr = {2,1,2};
        System.out.println(findAllSubsets(arr));
        System.out.println(findAllSubsetsWithoutDuplicates(dupArr));
    }

    static ArrayList<ArrayList<Integer>> findAllSubsets(int[] arr) {
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        // to avoid empty list error when looping through the list
        subsets.add(new ArrayList<>());
        for (int num : arr) {
            ArrayList<ArrayList<Integer>> tempSubsets = new ArrayList<>();
            for (ArrayList<Integer> subset : subsets) {
                ArrayList<Integer> tempSubset = new ArrayList<>(subset);
                tempSubset.add(num);
                tempSubsets.add(tempSubset);
            }
            subsets.addAll(tempSubsets);
        }
        return subsets;
    }

    // subsets without duplicates (duplicates in the final list)
    static ArrayList<ArrayList<Integer>> findAllSubsetsWithoutDuplicates(int[] arr) {
        // sort so that duplicates element are present adjacent to each other in the arr
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        // to avoid empty list error when looping through the list
        subsets.add(new ArrayList<>());
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            start = 0;
            // if found duplicate
            if (i > 0 && arr[i] == arr[i - 1]) {
                // start with previous list end + 1
                start = (int) Math.pow(2, i - 1);
            }
            ArrayList<ArrayList<Integer>> tempSubsets = new ArrayList<>();
            for (int j = start; j < subsets.size(); j++) {
                ArrayList<Integer> tempSubset = new ArrayList<>(subsets.get(j));
                tempSubset.add(arr[i]);
                tempSubsets.add(tempSubset);
            }
            subsets.addAll(tempSubsets);
        }
        return subsets;
    }

    // alternate solution
    static ArrayList<ArrayList<Integer>> findAllSubsetsWithoutDuplicatesTwo(int[] arr) {
        // sort so that duplicates element are present adjacent to each other in the arr
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        // to avoid empty list error when looping through the list
        subsets.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            start = 0;
            // if found duplicate
            if (i > 0 && arr[i] == arr[i - 1]) {
                // start with previous list end + 1
                start = end + 1;
            }
            end = subsets.size() - 1;
            ArrayList<ArrayList<Integer>> tempSubsets = new ArrayList<>();
            for (int j = start; j < subsets.size(); j++) {
                ArrayList<Integer> tempSubset = new ArrayList<>(subsets.get(j));
                tempSubset.add(arr[i]);
                tempSubsets.add(tempSubset);
            }
            subsets.addAll(tempSubsets);
        }
        return subsets;
    }
}