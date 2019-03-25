package day04;

import java.util.function.LongToDoubleFunction;

public class BoxTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);

        System.out.println(System.currentTimeMillis() - start);
    }
}




