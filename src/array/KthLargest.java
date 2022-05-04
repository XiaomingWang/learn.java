package array;


import java.util.Arrays;

/**
 * 215. Kth Largest Element in an Array
 * <p>
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Example 1:
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * <p>
 * Constraints:
 * 1 <= k <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 */
public class KthLargest {

    /**
     * Bubble sort is not the best solution.
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest_1(int[] nums, int k) {
        int n = nums.length;

        if (k > n) return -1;
        int l = k;
        for (int i = n - 1; i > 0 && l > 0; i--, l--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        for (int i : nums) {
            System.out.printf("%d, ", i);
        }

        return nums[n - k];
    }


    public int findKthLargest(int[] nums, int k) {
        if (k > nums.length) {
            return -1;
        }
        return quickFindKthLargest(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickFindKthLargest(int[] nums, int l, int r, int k) {
        if (l < r) {
            int i = partition(nums, l, r);
            if (i == k) {
                return nums[i];
            } else {
                return i < k ? quickFindKthLargest(nums, i + 1, r, k) : quickFindKthLargest(nums, l, i - 1, k);
            }
        }
        return nums[k];
    }

    int partition(int[] nums, int l, int r) {
        int i = l, j = r;
        int pivot = nums[l];
        while (i < j) {
            for (; i < j && nums[j] >= pivot; j--) {

            }
            for (; i < j && nums[i] < pivot; i++) {

            }
            if (i < j) {
                swap(nums, i, j);
            }
        }

        if (i < j && l < i) {
            swap(nums, l, i);
        }

        return i;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        // int[] nums = {3,2,1,5,6,4};
        // int[] nums = {8, 7, 3, 2, 11, 3, 1, 2, 14, 5, 7, 6};
        // int[] nums = {1, 2, 3, 4, 5, 6};
        int[] nums = {6, 5, 4, 3, 2, 1};
        // int k = 2;
        int k = 2;
        int expected = 5;
        KthLargest solution = new KthLargest();

        int result = solution.findKthLargest(nums, k);
        // System.out.println(result);
        System.out.printf("expected: %d, get: %d, result: %b.", expected, result, result == expected);

    }


}
