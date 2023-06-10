package threads.sync_test;

public class Student {

    int bookCount = 5;      // 공유 자원

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    // synchronized <--
    public synchronized void borrowBook() throws InterruptedException {
        int m = bookCount;
        Thread.sleep(2000);
        bookCount = m + 1;
        System.out.println("대출완료");
    }

    // synchronized <--
    public synchronized void returnBook() throws InterruptedException {
        int m = bookCount;
        Thread.sleep(3000);
        bookCount = m - 1;
        System.out.println("반납완료");
    }
}
