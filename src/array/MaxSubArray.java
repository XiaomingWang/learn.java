package array;


/**
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * A subarray is a contiguous part of an array.
 *
 * Example 1:
 *  Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 *  Output: 6
 *  Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaxSubArray {


    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int n = nums.length;
        int sum = nums[0];
        int max = nums[0];
        for(int i = 1; i < n; i++) {
            sum = Math.max(sum + nums[i], nums[i]);

            if (max < sum) {
                max = sum;
            }
        }

        return max;
    }


    public static void main(String[] args) {

        MaxSubArray solution = new MaxSubArray();
        // int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = {-2,-1,-3};
        int max = solution.maxSubArray(nums);
        System.out.println(max);
    }

}
