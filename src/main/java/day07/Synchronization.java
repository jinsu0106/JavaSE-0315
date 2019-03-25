package day07;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

public class Synchronization {
    public static void main(String[] args) {
        Food water = new Food("water");
        Food fish = new Food("fish");
        Food Bone = new Food("bone");

        Cat cat = new Cat("Kitty", fish);
        Dog dog = new Dog("Tiger", Bone);

        cat.start();
        dog.start();
    }
}

class Food {

    private String name;

    public Food(String name) {
        this.name = name;
    }

    synchronized void eat1() {
        System.out.println(Thread.currentThread().getName() + " is eating " + name + ": start...");

        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " is eating " + name + ": end...");
    }

    void eat2() {
        // ...
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " is eating " + name + ": start...");

            try {
                Thread.sleep(1000 * 3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " is eating " + name + ": end...");

        }
    }

    synchronized static void eat3() {
        System.out.println(Thread.currentThread().getName() + " is eating " + ": start...");

        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " is eating " + ": end...");

    }
}

class Cat extends Thread {

    private Food food;

    Cat(String name, Food food) {
        // super.test();
        // super();
        super(name); // ?
        this.food = food;
    }

    @Override
    public void run() {
//        food.eat1();
//        food.eat2();
        food.eat3();

    }
}

class Dog extends Thread {

    private Food food;

    public Dog(String name, Food food) {
        super(name);
        this.food = food;
    }

    @Override
    public void run() {
//        food.eat1();
//        food.eat2();
        food.eat3();
    }
}