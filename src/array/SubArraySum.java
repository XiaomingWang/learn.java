package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. Subarray Sum Equals K
 * <p>
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 * <p>
 * Example 1:
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * <p>
 * Constraints:
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -10^7 <= k <= 10^7
 */
public class SubArraySum {


    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int count = 0;
        int sum = 0;
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }


    public static void main(String[] args) {
//        int[] nums = {11, -2, 1, 1, 6, 1, 7, 1, 9, 8, 5, 2, -1, 10, 9};
//        int k = 9;
        int[] nums = {1, 1, 1, -1, 2, 0, 3};
        int k = 3;
//        int[] nums = {-1, -1, 1};
//        int k = 0;
//        int[] nums = {1, 0, -1, 0, 1};
//        int k = 0;
        SubArraySum solution = new SubArraySum();
        int count = solution.subarraySum(nums, k);
        System.out.println(count);
    }


}
