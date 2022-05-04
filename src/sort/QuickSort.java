package sort;


import java.util.Arrays;

/**
 * @author Xiaoming Wang
 */
public class QuickSort {


    /**
     * @param nums
     * @param left
     * @param right
     */
    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int i = partition_1(nums, left, right);

            quickSort(nums, left, i - 1);
            quickSort(nums, i + 1, right);
        }
    }

    static int partition_1(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left;
        int j = right;

        while (i < j) {
            for (; i < j && nums[j] >=pivot; j--) {
                // Get the small one.
            }
            for (; i < j && nums[i] <= pivot; i++) {
                // Get the large one.
            }

            if (i < j) {
                swap(nums, i, j);
            }
        }
        if (left < i && nums[i] < pivot) {
            swap(nums, left, i);
        }

        System.out.printf("left: %d, right: %d, pivot: %d, final (i, j): (%d, %d).", left, right, pivot, i, j);
        System.out.printf("  arrays: %s.", Arrays.toString(nums));
        System.out.printf("\n");
        return i;
    }

    static int partition_2(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }

            while (i < j && nums[i] < pivot) {
                i++;
            }

            if (i < j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = pivot;
        System.out.printf("left: %d, right: %d, pivot: %d, final (i, j): (%d, %d).", left, right, pivot, i, j);
        System.out.printf("  arrays: %s.", Arrays.toString(nums));
        System.out.printf("\n");
        return i;
    }

    static int partition(int[] nums, int left, int right) {
        int x = nums[right], i = left - 1;
        for (int j = left; j < right; ++j) {
            if (nums[j] <= x) {
                swap(nums, ++i, j);
            }
        }
        swap(nums, i + 1, right);
        System.out.printf("left: %d, right: %d, pivot: %d, final (i): (%d).", left, right, x, i);
        System.out.printf("  arrays: %s.", Arrays.toString(nums));
        System.out.printf("\n");
        return i + 1;
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        // int[] numbs = {6, 12, 6, 23, 1, 3, 4, 7, 92};

        int[] numbs = {4, -1, 8, 7, 3, 2, 11, 3, 1, 2, 14, 5, 7, 6};

        // int[] numbs = {6, 5, 4, 3, 2, 1};
        quickSort(numbs, 0, numbs.length - 1);

        for (int i : numbs) {
            System.out.printf("%d, ", i);

        }
    }


}
