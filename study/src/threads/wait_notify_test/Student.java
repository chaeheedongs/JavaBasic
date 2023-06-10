package threads.wait_notify_test;

public class Student {

    int bookCount = 0;      // 공유 자원

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public synchronized void borrowBook() throws InterruptedException {
        if(bookCount>=10){
            try{
                System.out.println("10권 초과로 대출할 수 없습니다");
                wait(); // <----
            }catch (Exception e){

            }
        }
        int m = bookCount;
        bookCount = m+1;
        System.out.println("책 대출 성공. 대출한 책의 갯수 : "+bookCount);
        notify(); // <-----
    }

    public synchronized void returnBook() throws InterruptedException {
        if(bookCount<=0){
            try{
                System.out.println("반납할 책이 없습니다");
                wait(); // <----
            }catch (Exception e){

            }
        }
        int m = bookCount;
        bookCount = m-1;
        System.out.println("책 반납 성공. 대출한 책의 갯수 : "+bookCount);
        notify(); // <-----
    }
}
