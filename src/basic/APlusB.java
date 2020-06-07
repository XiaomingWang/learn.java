package basic;

public class APlusB {

    /**
     * @param a: An integer
     * @param b: An integer
     * @return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        return b == 0 ? a : aplusb(a ^ b, (a & b) << 1);
    }

    /**
     * @param a: An integer
     * @param b: An integer
     * @return The reduction for a and b.
     */
    public int aminusb(int a, int b) {
        b = ~b + 1;
        return aplusb(a, b);
    }

    public static void main(String[] args) {
        int a = 24;
        int b = 13;
        int c = ~b + 1;
        System.out.println("-b: " + c);

        APlusB solution = new APlusB();
        System.out.println(a + " + " + b + " = " + solution.aplusb(a, b));
        System.out.println(a + " - " + b + " = " + solution.aminusb(a, b));
    }

}