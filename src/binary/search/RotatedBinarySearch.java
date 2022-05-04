package binary.search;

/**
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
