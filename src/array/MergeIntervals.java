package array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. Merge Intervals
 *
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 *  Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 * Constraints:
 * 1 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10^4
 *
 *
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        // sort first.
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

        int n = intervals.length;
        int[][] res = new int[n][2];
        int idx = -1;
        for (int i = 0; i < n; i++) {
            int[] interval = intervals[i];
            if (idx == -1 || res[idx][1] < interval[0]) {
                idx += 1;
                res[idx] = interval;
            } else {
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }

        return Arrays.copyOf(res, idx + 1);
    }


    public static void main(String[] args) {
        MergeIntervals solution = new MergeIntervals();
        int[][] intervals = {{1, 3}, {2, 4}, {5, 7}, {6, 9}, {0, 2}, {11, 20}};
        int[][] ans = solution.merge(intervals);

        System.out.println(Arrays.toString(ans));

    }

}
