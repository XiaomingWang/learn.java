package sort;

import java.util.Arrays;

/**
 * How to
 *
 * @author Xiaoming Wang
 */
public class SelectSort {

    public static int[] selectSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[min] > a[j]) min = j;
            }

            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }

        return a;
    }


    public static void main(String[] args) {
        int[] a = {3, 2, 1, 4, 9, 2, 6, 0, -1};
        selectSort(a);
        System.out.println(Arrays.toString(a));
    }


}
