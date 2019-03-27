package day08;

public class FibonacciTest {
    private static int fibonacci(int n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2); // recursive 递归算法
        }
    }

    public static void main(String[] args) {
        int n = 80;
        System.out.println(fibonacci(n));
    }
}

