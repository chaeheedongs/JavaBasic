package threads.wait_notify_test;

public class ReturnThread extends Thread {
    @Override
    public void run() {
        for(int i=0;i<30;i++){
            try {
                Library.student.returnBook();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
