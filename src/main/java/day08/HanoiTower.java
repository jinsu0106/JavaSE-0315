package day08;

import java.util.Scanner;

public class HanoiTower {

    private static int counter;

    private static void hanoi(int n, char src, char with, char dest) {
        // recursive call
        if (n == 1) {
            System.out.println(src + " -> " + dest);
            counter++;
        } else {
            hanoi(n - 1, src, dest, with);
            System.out.println(src + " -> " + dest);
            counter++;
            hanoi(n - 1, with, src, dest);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input number N: ");
        int n = scanner.nextInt();

        hanoi(n, 'A', 'B', 'C');

        System.out.println("counter: " + counter);
    }
}

