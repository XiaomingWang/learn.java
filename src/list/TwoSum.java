package list;


import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * <p>
 * Examples:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * </p>
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return new int[]{};
        }
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int diff = 0;

        for (int i = 0; i < nums.length; i++) {
            result[1] = i;
            diff = target - nums[i];
            if (map.get(nums[i]) != null) {
                result[0] = map.get(nums[i]);

                return result;
            }
            map.put(diff, i);
        }
        return new int[2];
    }


    public static void main(String[] args) {
        int[] nums = {12, 17, 22, 29, 44, 6, 50};
        int target = 66;
        int[] result = twoSum(nums, target);
        System.out.printf("Target: %d, two number indexes: [%d, %d]. \n", target, result[0], result[1]);
    }


}
