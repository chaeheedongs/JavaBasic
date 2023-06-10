package threads;

public class ThreadBasic {

    public static void main(String[] args) throws InterruptedException {

//        Runnable runnableClass = new RunnableClass();
//        runnableClass.run();

        ThreadClass threadClass1 = new ThreadClass(1);
        ThreadClass threadClass2 = new ThreadClass(2);
//        threadClass1.run();
//        threadClass1.start();
//        threadClass2.start();

        /**
         * Thread.toString()
         * - getName()
         * ---> 쓰레드 이름
         * - getPriority()
         * ---> 쓰레드 우선 순위
         * - ThreadGroup.getName()
         * ---> 쓰레드 그룹 이름
         */
//        System.out.println("threadClass1 = " + threadClass1);
//        System.out.println("threadClass2 = " + threadClass2);


        /**
         * 쓰레드 우선 순위 변경하기
         * - setPriority(int newPriority)
         * ---> 우선 순위를 변경할 수 있다.
         * - getPriority()
         * ---> 우선 순위를 조회 한다.
         */
//        System.out.println("threadClass1 = " + threadClass1.getPriority());
//        System.out.println("threadClass2 = " + threadClass2.getPriority());
//
//        threadClass1.setPriority(1);
//        threadClass2.setPriority(10);
//
//        System.out.println("threadClass1 = " + threadClass1.getPriority());
//        System.out.println("threadClass2 = " + threadClass2.getPriority());

        /**
         * Thread 상태 확인 하기
         */
        Thread thread = new Thread();
        System.out.println("Create Thread : " + thread.getState());

        thread.start();
        System.out.println(" Start Thread : " + thread.getState());

        thread.join();
        System.out.println("  Stop Thread : " + thread.getState());
    }
}
