public class UnitTest {


    public static void main(String[] args) {
        int a = Integer.MAX_VALUE, b = 0;
        System.out.printf("a: %d, b: %d \n", a, b);

        a = a ^ b;
        b = b ^ a;
        a = a ^ b;

        System.out.printf("a: %d, b: %d", a, b);
    }

}
