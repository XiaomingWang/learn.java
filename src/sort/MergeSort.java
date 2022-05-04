package sort;

import java.util.Arrays;

public class MergeSort {

    public static int[] mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            a = mergeSort(a, left, mid);
            a = mergeSort(a, mid + 1, right);
            merge(a, left, mid, right);
        }

        return a;
    }

    private static void merge(int[] a, int left, int mid, int right) {
        int[] b = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (a[i] < a[j]) b[k++] = a[i++];
            else b[k++] = a[j++];
        }
        while (i <= mid) b[k++] = a[i++];
        while (j <= right) b[k++] = a[j++];
        for(i = 0; i < k; i++) {
            a[left++] = b[i];
        }

    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 3, 2, 0};
        mergeSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }



}
