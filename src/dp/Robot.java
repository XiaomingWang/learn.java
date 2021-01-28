package dp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author xiaoming
 * @since 2.0
 */
public class Robot {

    // Map<String, Integer> states = new HashMap<>();

    int move(int m, int n, int[][] states) {
        if (m <= 1 && n <= 1) {
            return 0;
        }
        if (m == 1) {
            return 1;
        } else if (n == 1) {
            return 1;
        }

        int ret = move(m - 1, n, states) + move(m, n - 1, states);
        if (states[m - 1][n - 1] > 0) {
            return states[m - 1][n - 1];
        } else {
            states[m - 1][n - 1] = ret;
        }

        return ret;
    }

    public static void main(String[] args) {
        int m = 27, n = 27;
        int[][] states = new int[m][n];
        Robot robot = new Robot();
        System.out.println(robot.move(m, n, states));
    }

}
