package threads.deadlock_test;

import static threads.deadlock_test.Main.object1;
import static threads.deadlock_test.Main.object2;

public class FirstThread extends Thread {

    @Override
    public void run() {

        synchronized (object1) {
            System.out.println("First Thread has object1 lock");
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("First Thread want to have object2's lock. so wait");

        synchronized (object2) {
            System.out.println("First Thread has object2 lock too");
        }
    }
}
