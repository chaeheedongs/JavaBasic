package threads.deadlock_test;

import static threads.deadlock_test.Main.object1;
import static threads.deadlock_test.Main.object2;

public class SecondThread extends Thread {

    @Override
    public void run() {

        synchronized (object2) {
            System.out.println("Second Thread has object2 lock");
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Second Thread want to have object1 lock, so wait");

        synchronized (object1){
            System.out.println("Second Thread has object1 lock too");
        }
    }
}
