package day07;

public class MT1 extends Thread{
    public static void main(String[] args) {
        MT1 mt1 = new MT1();
        mt1.start();
        System.out.println("test...");
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
