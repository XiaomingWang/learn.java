package binary.search;

/**
 * @author xiaoming
 * @since 2.0
 */
public class Power {

    int pow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int carrier = 1;
        while (n > 1) {
            if (n % 2 == 1) {
                carrier = carrier * x;
            }
            n = n >> 1;
            x = x * x;
        }

        return x * carrier;
    }

    public static void main(String[] args) {
        Power solution = new Power();
        System.out.println(solution.pow(3, 2));
    }

}
