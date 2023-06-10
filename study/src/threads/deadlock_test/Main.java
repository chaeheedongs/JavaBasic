package threads.deadlock_test;

public class Main {

    public static Object object1 = new Object();
    public static Object object2 = new Object();

    public static void main(String[] args) {

        FirstThread firstThread = new FirstThread();
        SecondThread secondThread = new SecondThread();

        firstThread.start();
        secondThread.start();

    }
}
