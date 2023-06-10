package threads;

public class ThreadClass extends Thread {

    int threadNumber;

    public ThreadClass(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 5; i++) {
            System.out.println("[" + this.threadNumber + "] ThreadClass run() = " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { }

        }

    }


}
