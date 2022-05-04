package basic;

public class SquareRoot {

    public int mySqrt(int x) {
        if (x < 0) {
            return -1;
        }
        long left = 0;
        long right = x;
        while (left < right) {
            long mid = (left + right + 1) / 2;
            if ((mid * mid) > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return (int) left;
    }

    public static void main(String[] args) {
        System.out.println(~0);
        SquareRoot solution = new SquareRoot();
        int ret = solution.mySqrt(16);
        System.out.println("The square root is: " + ret);
    }
}
