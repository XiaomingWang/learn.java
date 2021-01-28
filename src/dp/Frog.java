package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaoming
 * @since 2.0
 */
public class Frog {

    Map<Integer, Integer> states = new HashMap<>();

    public int jump(int n) {
        if (n < 1)
            return 0;
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int ret = jump(n - 1) + jump(n - 2);
        if (states.get(n) != null) {
            return states.get(n);
        } else {
            states.put(new Integer(n), ret);
        }
        return ret;
    }

    public static void main(String[] args) {
        Frog frog = new Frog();
        System.out.println(frog.jump(9));
    }


}
