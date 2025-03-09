package junit.threads;

import org.junit.jupiter.api.Test;

public class Step1_ThreadRunnableTest {

    static class CustomThread extends Thread {
        @Override
        public void run() {
            System.out.println("CustomThread.run: " + Thread.currentThread().getName());
        }
    }

    @Test
    void thread_start_test() {
        /* Thread.start() 메서드는 쓰레드 공유하지 않음 - main 이후 다음 스레드로 처리 */
        CustomThread thread = new CustomThread();
        thread.start(); // 2: Thread-0

        System.out.println("thread.start: " + Thread.currentThread().getName()); // 1: main Thread
    }

    @Test
    void thread_run_test() {
        /* Thread.run() 메서드는 쓰레드 공유 */
        CustomThread thread = new CustomThread();
        thread.run(); // 1: main
        thread.run(); // 2: main
        thread.run(); // 3: main
        thread.run(); // 4: main
        thread.run(); // 5: main
        System.out.println("thread.run: " + Thread.currentThread().getName()); // 6: main
    }

    @Test
    void runnable_annonymous_test() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable.annonymous.run: " + Thread.currentThread().getName());
            }
        };

        runnable.run(); // 1: main (즉시 실행)
        System.out.println("runnable.run: " + Thread.currentThread().getName()); // 2: main
    }

    @Test
    void runnable_lambda_test() {
        Runnable runnable = () -> System.out.println("runnable.lambda.run: " + Thread.currentThread().getName());
        runnable.run(); // 1: main (즉시 실행)

        System.out.println("runnable.run: " + Thread.currentThread().getName()); // 2: main
    }
}
