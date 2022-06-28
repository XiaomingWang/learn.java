package binary.search;

/**
 * 33. Search in Rotated Sorted Array
 *
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 * @author xiaoming
 * @since 2.0
 */
public class RotatedBinarySearch {

    public int solution(int[] inputs, int target) {
        if (inputs.length == 0) {
            return -1;
        }
        int left = 0, right = inputs.length - 1;

        // int loop = 1;
        while (left < right) {
            // System.out.println("Loop: " + loop++ + ", left: " + left + ", right: " + right);
            if (target == inputs[left]) {
                return left;
            } else if (target == inputs[right]) {
                return right;
            }
            int mid = left + (right - left) / 2;
            if (inputs[mid] == target) {
                return mid;
            }
            if (inputs[left] <= inputs[mid]) {
                if (target < inputs[mid] && target >= inputs[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > inputs[mid] && inputs[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] inputs = new int[]{88, 90, 99, 1, 3, 7, 13, 17, 19, 22, 34, 67, 87};
        int target = 34;
        RotatedBinarySearch solution = new RotatedBinarySearch();
        int index = solution.solution(inputs, target);
        System.out.println(index);
    }

}
