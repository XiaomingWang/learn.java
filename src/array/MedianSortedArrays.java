package array;


/**
 *
 * 4. Median of Two Sorted Arrays
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 *
 *
 * Example 1:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 *
 * Example 2:
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 */
public class MedianSortedArrays {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        boolean isOdd = (m + n) % 2 == 1;

        int value1 = 0;
        int value2 = 0;

        return isOdd ?  (double) value1 : (value1 + value2) / 2.0;
    }


    public static void main(String[] args) {
        // Median:  1. when the array size is odd, return the median value;
        //          2. when the array size is an even number, then return the mean value of middle of the two values.


    }

}
