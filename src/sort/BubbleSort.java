package sort;

import java.util.Arrays;

/**
 *
 * @author Xiaoming Wang
 */
public class BubbleSort {

    public static int[] bubbleSort(int[] a) {

        int n = a.length;
        for (int i = n - 1; i > 0; i--) {
            // int j = i;
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        //int[] arr = {9, 11, -1, 16, 7, -2, 19, 5, 4, 3};
        int[] arr = {3, -1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
