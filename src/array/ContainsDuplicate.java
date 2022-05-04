package array;


import java.util.HashSet;
import java.util.Set;

/**
 *
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 *
 *  Example 1:
 *  Input: nums = [1,2,3,1]
 *  Output: true
 *
 *  Example 2:
 *  Input: nums = [1,2,3,4]
 *  Output: false
 *
 *  Constraints:
 *      1 <= nums.length <= 10^5
 *      -10^9 <= nums[i] <= 10^9
 */
public class ContainsDuplicate {


    /**
     *
     * Time complexity: O(n)
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums.length < 2) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }

        return false;
    }


    public static void main(String[] args) {
        int[] nums = {-1, -1, -1, 3, 3, 4, 3, 2, 4, 2};

        ContainsDuplicate solution = new ContainsDuplicate();

        boolean result = solution.containsDuplicate(nums);

        System.out.println("Result is: " + result);

    }


}
