package threads.wait_notify_test;

public class Main {

    public static void main(String[] args) {
        System.out.println("현재 대출한 책의 갯수 : "+Library.student.getBookCount());

        BorrowThread bt = new BorrowThread();
        ReturnThread rt = new ReturnThread();

        bt.setPriority(10);
        bt.start();
        rt.start();

        try{
            bt.join();
            rt.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
