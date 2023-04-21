public class SplitArray {
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int result = splitArray(nums,3);
        System.out.println(result);
    }

    static int splitArray(int[] nums,int m) {
        int start = 0;
        int end = 0;

        for (int num: nums) {
            start = Math.max(start,num); // in the end this will contain the max item of array
            end += num; // sum of all elements of the array
        }

        // perform binary search for potential answer
        while (start < end) {
            // try mid for potential ans
            int mid = start + (end - start) / 2;

            // calculate how many pieces you can divide this in with max sum
            int sum = 0;
            int pieces = 1;

            for (int num: nums) {
                if (sum + num > mid) {
                    // now you cannot add further elements in this sub-array create a new one
                    // then the sum of the new sub-array will be num and pieces will increment
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }

            if (pieces > m) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end; // here start == end
    }
}
