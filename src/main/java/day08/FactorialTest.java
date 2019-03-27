package day08;

public class FactorialTest {

    private static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(factorial(n));

        long sum = 0L;
        for (int i = 0; i < 21; i++) {
            sum += factorial(i + 1);
        }
        System.out.println(sum);
    }
}