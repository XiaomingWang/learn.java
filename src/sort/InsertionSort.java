package sort;

import java.util.Arrays;

/**
 * @author Xiaoming Wang
 */
public class InsertionSort {


    public static int[] insertionSort(int[] a) {

        for (int i = 1; i < a.length; i++) {
            int j = i;
            int temp = a[i];
            while (j > 0 && a[j - 1] > a[j]) {
                a[j] = a[j - 1];
                a[j - 1] = temp;
                j--;
            }
        }

        return a;
    }

    public static void main(String[] args) {
        // int[] arr = {11, 3, 2, 3, 5, 9, 91, -1, 3};
        int[] arr = {11, -11, -2, 3};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));

    }


}
