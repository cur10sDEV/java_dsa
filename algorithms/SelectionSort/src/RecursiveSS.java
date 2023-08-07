import java.util.Arrays;

public class RecursiveSS {
    public static void main(String[] args) {
        int[] arr = new int[] {5,4,3,2,1,0,-1};
        recursiveSS(arr,arr.length-1,arr.length-2,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static int[] recursiveSS(int[] arr,int i, int j,int max) {
        if (i <= 0) {
            return arr;
        } else if (j < 0) {
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            i--;
            j=i-1;
            return recursiveSS(arr,i,j,i);
        } else {
            if (arr[j] > arr[max]) {
                max = j;
            }
            return recursiveSS(arr,i,j-1,max);
        }
    }
}
