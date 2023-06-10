package threads;

public class RunnableClass implements Runnable {

    @Override
    public void run() {

        for (int i = 1; i <= 5; i++) {
            System.out.println("RunnableClass run() = " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { }

        }

    }
}
