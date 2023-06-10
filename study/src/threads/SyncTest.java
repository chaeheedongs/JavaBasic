package threads;

/**
 * 동기화
 * - 방법
 *   - 임계 영역 (Critical Session)
 *     - 공유 자원에 대해 하나의 스레드만 접근 하도록 한다. (1 Process)
 *   - 뮤텍스 (Mutex)
 *     - 공유 자원에 대해 하나의 스레드만 접근 하도록 한다. (N process)
 *   - 이벤트 (Event)
 *     - 특정 이벤트의 발생을 타 스레드에게 전파 한다.
 *   - 세마포어 (Semapore)
 *     - 한정된 개수의 자원을 여러 스레드가 사용하고자 할 때 접근을 제한 한다.
 *   - 대기 타이머 (Waitable Timer)
 *     - 특정 시간에 대기 스레드를 활성화 한다.
 */

class Item {

    int itemCount = 999; // 공통 자원

    public int getItemCount() {
        return itemCount;
    }

    // synchronized 키워드
    public synchronized void buy() throws InterruptedException {
        int count = itemCount;
        Thread.sleep(2000);
        itemCount = count + 1;
        System.out.println("구매 완료");
    }

    // synchronized 키워드
    public synchronized void refund() throws InterruptedException {
        int count = itemCount;
        Thread.sleep(2000);
        itemCount = count - 1;
        System.out.println("환불 완료");
    }
}

class Shop {

    public static Item item = new Item();
}

class CustomerFoo extends Thread {

    @Override
    public void run() {

        try {
            Shop.item.buy(); // 구매
        } catch (InterruptedException e) { }

        System.out.println("Item의 재고 수량 : " + Shop.item.getItemCount());
    }
}

class CustomerBar extends Thread {

    @Override
    public void run() {

        try {
            Shop.item.refund(); // 환불
        } catch (InterruptedException e) { }

        System.out.println("Item의 재고 수량 : " + Shop.item.getItemCount());
    }
}

public class SyncTest {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("현재 상품 재고 개수 : " + Shop.item.getItemCount());

        CustomerFoo foo = new CustomerFoo(); // 구매
        CustomerBar bar = new CustomerBar(); // 환불

        bar.setPriority(10); // bar 고객의 우선순위를 5 -> 10으로 변경

        // 시작
        foo.start();
        bar.start();

        // 종료
        foo.join();
        bar.join();
    }
}
