# 쓰레드

## 목차

---

- Thread 클래스와 Runnable 인터페이스
- Runnable 예제
- Thread 예제
- 쓰레드의 상태
- 쓰레드의 우선순위
- 동기화
- 데드락

---

<br/><br/><br/>

### Thread 클래스와 Runnable 인터페이스

---

> Runnable Interface

- java.lang.Runnable
- 함수형 인터페이스 이다.
- Runnable 인터페이스의 구현체는 매개 변수가 없는 run() 메서드를 정의 해야 한다.

```java
package java.lang;

/**
 * Runnable 인터페이스는 스레드에 의해 인스턴스가 실행되도록 하는 
 * 모든 클래스에 의해 구현되어야 합니다.
 * 
 * 클래스는 run이라고 하는 인수가 없는 메서드를 정의해야 합니다.
 *
 * 이 인터페이스는 활성화된 동안 코드를 실행하고자 하는 객체에 
 * 공통 프로토콜을 제공하도록 설계되었다.
 * 
 * 예를 들어,
 * 실행 가능은 클래스 스레드별로 구현됩니다.
 * 활성은 스레드가 시작되었고 아직 중지되지 않았음을 의미합니다.
 * 
 * 또한 실행 가능은 스레드를 하위 클래스로 분류하지 않으면서 
 * 클래스가 활성화될 수 있는 수단을 제공합니다.
 * 
 * 실행 가능을 구현하는 클래스는 스레드 인스턴스를 인스턴스화하고 
 * 자신을 대상으로 전달하여 스레드 하위 분류 없이 실행할 수 있습니다.
 * 
 * 대부분의 경우 run() 메서드만 재정의하고
 * 다른 스레드 메서드는 재정의하지 않을 계획인 경우
 * 실행 가능 인터페이스를 사용해야 합니다.
 * 
 * 이것은 프로그래머가 클래스의 근본적인 행동을 
 * 수정하거나 강화하려는 의도가 아니라면 
 * 클래스를 하위 분류해서는 안 되기 때문에 중요하다.
 *
 * @author  Arthur van Hoff
 * @see     java.lang.Thread
 * @see     java.util.concurrent.Callable
 * @since   1.0
 */
@FunctionalInterface
public interface Runnable {
    /**
     * 인터페이스를 구현하는 개체가 스레드를 만드는 데 사용될 때 
     * 스레드를 시작하면 개체의 실행 메서드가 
     * 별도로 실행되는 스레드에서 호출됩니다.
     * 
     * run 메서드의 일반적인 계약은 어떠한 조치도 취할 수 있다는 것이다.
     *
     * @see     java.lang.Thread#run()
     */
    public abstract void run();
}
```

<br/>

> Thread Class

- java.lang.Thread
- Runnable 인터페이스의 구현체 이다.
- Thread 클래스를 상속 받아 커스텀 Thread 클래를 생성 하기도 한다.

```java
/**
 * 스레드는 프로그램에서 실행되는 스레드를 말합니다.
 *
 * Java Virtual Machine을 사용하면 
 * 응용 프로그램이 여러 실행 스레드를 동시에 실행할 수 있습니다.
 * 
 * 모든 쓰레드에는 우선 순위가 있습니다. 
 * 우선순위가 높은 스레드는 우선순위가 낮은 스레드보다 우선하여 실행됩니다.
 * 각 스레드는 데몬으로 표시될 수도 있고 표시되지 않을 수도 있습니다.
 * 일부 스레드에서 실행 중인 코드가 새 {@code Thread} 개체를 생성할 때
 * 새 스레드의 우선 순위는 처음에 생성 스레드의 우선 순위와 동일하게 설정되며,
 * 생성 스레드가 데몬인 경우에만 데몬 스레드가 됩니다.
 * 
 * Java Virtual Machine이 시작될 때
 * 일반적으로 데몬이 아닌 스레드가 하나 있습니다
 * (일반적으로 일부 지정된 클래스의 {@code main}이라는 메서드를 호출함).
 * Java Virtual Machine은 다음 중 하나가 될 때까지 스레드를 계속 실행합니다.
 * 발생:
 * 
 * 클래스 {@code Runtime}의 {@code Exit} 메서드가 호출되었으며 
 * 보안 관리자가 종료 작업을 수행하도록 허용했습니다.
 * 
 * 호출에서 {@code run} 메서드로 돌아가거나 
 * {@code run} 메서드를 넘어 전파되는 예외를 던져서 
 * 데몬 스레드가 아닌 모든 스레드가 중지되었습니다.
 * 
 * 
 * 실행 스레드를 새로 만드는 방법에는 두 가지가 있습니다.
 * One is to
 * 하나는 클래스를 {@code Thread}의 하위 클래스로 선언하는 것입니다. 
 * 이 하위 클래스는 클래스 {@code Thread}의 {@code run} 메서드를 재정의해야 합니다.
 * 그런 다음 하위 클래스의 인스턴스를 할당하고 시작할 수 있습니다.
 * 예를 들어, 명시된 값보다 큰 소수를 계산하는 스레드는 다음과 같이 쓸 수 있다.
 * =============================================================================
 *     class PrimeThread extends Thread {
 *         long minPrime;
 *         PrimeThread(long minPrime) {
 *             this.minPrime = minPrime;
 *         }
 *
 *         public void run() {
 *             // compute primes larger than minPrime
 *         }
 *     }
 * =============================================================================
 * 
 * 다음 코드는 스레드를 생성하고 실행을 시작합니다.
 * =============================================================================
 *     PrimeThread p = new PrimeThread(143);
 *     p.start();
 * =============================================================================
 * 
 * 스레드를 생성하는 다른 방법은 {@code Runnable} 인터페이스를 구현하는 클래스를 선언하는 것입니다.
 * 그런 다음 해당 클래스는 {@code run} 메서드를 구현합니다.
 * 그런 다음 클래스의 인스턴스를 할당하고 
 * {@code Thread}을(를) 생성할 때 인수로 전달하고 시작할 수 있습니다. 
 * 이 다른 스타일의 동일한 예는 다음과 같습니다.
 * =============================================================================
 *     class PrimeRun implements Runnable {
 *         long minPrime;
 *         PrimeRun(long minPrime) {
 *             this.minPrime = minPrime;
 *         }
 *
 *         public void run() {
 *             // compute primes larger than minPrime
 *         }
 *     }
 * =============================================================================
 * 
 * 다음 코드는 스레드를 생성하고 실행을 시작합니다.
 * =============================================================================
 *     PrimeRun p = new PrimeRun(143);
 *     new Thread(p).start();
 * =============================================================================
 * 
 * 모든 스레드에는 식별을 위한 이름이 있습니다.
 * 둘 이상의 스레드가 동일한 이름을 가질 수 있습니다.
 * 스레드가 작성될 때 이름이 지정되지 않은 경우,
 * 스레드에 대한 새 이름이 생성됩니다.
 * 
 * 명시되지 않은 클래스의 생성자 또는 메서드에 {@cod enull} 인수를 전달하면 
 * {@link NullPointerException} 예외을(를) 던집니다.
 * 
 * @author  unascribed
 * @see     Runnable
 * @see     Runtime#exit(int)
 * @see     #run()
 * @see     #stop()
 * @since   1.0
 */
public class Thread implements Runnable {
    //...
}
```

<br/><br/><br/>

### Runnable 예제

---

- 예제 코드를 통해 간단한 Runnable 구현체를 사용해 보자.
- run() 메서드 내용
  - 반복문을 실행 하면서 i 변수의 값을 출력 한다.
  - 쓰레드를 1초 쉬게 한다.
  - 이때 InterruptedException이 발생하면 아무런 작업을 하지 않는다.

```java
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
// =============================================================================
public class ThreadBasic {

    public static void main(String[] args) {

        Runnable runnableClass = new RunnableClass();
        runnableClass.run();
    }
}
// =============================================================================
// RunnableClass run() = 1
// RunnableClass run() = 2
// RunnableClass run() = 3
// RunnableClass run() = 4
// RunnableClass run() = 5
```

<br/><br/><br/>

### Thread 예제

---

- start() 와 run() 의 차이
  - start()
    - 새로운 스레드를 생성해서 사용하는 것이다.
    - 새로운 스레드의 run() 메서드를 호출 한다.
    - 병럴 처리가 된다.
  - run()
    - Thread 클래스의 내부 run() 메서드를 사용하는 것이다.
    - 새로운 스레드가 생기지 않는다.
    - 병렬 처리가 안된다.
- toString()
  - getName()
    - 쓰레드 이름
  - getPriority()
    - 쓰레드 우선 순위
  - ThreadGroup.getName()
    - 쓰레드 그룹 이름

```java
    /**
 * 스레드의 이름, 우선 순위 및 스레드 그룹을 포함하여
 * 이 스레드의 문자열 표현을 반환합니다.
 *
 * @return  이 스레드의 문자열 표현
 */
public String toString() {
  ThreadGroup group = getThreadGroup();
  if (group != null) {
    return "Thread[" + getName() + "," + getPriority() + "," +
  group.getName() + "]";
  } else {
    return "Thread[" + getName() + "," + getPriority() + "," +
  "" + "]";
  }
}
// =============================================================================
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
// =============================================================================
public class ThreadBasic {

  public static void main(String[] args) {

    ThreadClass threadClass1 = new ThreadClass(1);
    ThreadClass threadClass2 = new ThreadClass(2);
    threadClass1.start();
    threadClass2.start();
    
    // toString() 찍어 보기
    System.out.println("threadClass1 = " + threadClass1);
    System.out.println("threadClass1 = " + threadClass2);

  }
}
// =============================================================================
// start()-------------------run()
// [1] ThreadClass run() = 1 [1] ThreadClass run() = 1
// [2] ThreadClass run() = 1 [1] ThreadClass run() = 2
// [1] ThreadClass run() = 2 [1] ThreadClass run() = 3
// [2] ThreadClass run() = 2 [1] ThreadClass run() = 4
// [1] ThreadClass run() = 3 [1] ThreadClass run() = 5
// [2] ThreadClass run() = 3 [2] ThreadClass run() = 1
// [1] ThreadClass run() = 4 [2] ThreadClass run() = 2
// [2] ThreadClass run() = 4 [2] ThreadClass run() = 3
// [1] ThreadClass run() = 5 [2] ThreadClass run() = 4
// [2] ThreadClass run() = 5 [2] ThreadClass run() = 5
//
// threadClass1 = Thread[Thread-0,5,main]
// threadClass2 = Thread[Thread-1,5,main]
```

<br/><br/><br/>

### 쓰레드의 상태

---

|       상태     | 설명                                                   |
|:--------------:|:-------------------------------------------------------|
|      NEW       | 아직 시작되지 않은 스레드의 상태입니다.                |
|    RUNNABLE    | 실행 가능한 스레드의 상태입니다.                       |
|    BLOCKED     | 모니터 잠금을 기다리는 동안 차단된 스레드의 상태입니다.|
|    WAITING     | 대기 중인 스레드의 상태입니다.                         |
| TIMED_WAITTING | 지정된 대기 시간만큼 대기 중인 스레드 상태입니다.      |
|   TERMINATED   | 종료된 스레드의 상태입니다.                            |

```java
public class Thread implements Runnable {
    
  // ...
    
  public enum State {
      /**
       * 아직 시작되지 않은 스레드의 상태입니다.
       */
      NEW,
  
      /**
       * 실행 가능한 스레드의 상태입니다.
       * 
       * 실행 가능한 상태의 스레드가 Java Virtual Machine 에서 실행되고 있지만
       * 프로세서와 같은 운영 체제의 다른 리소스를 기다리고 있을 수 있습니다.
       */
      RUNNABLE,
  
      /**
       * 모니터 잠금을 기다리는 동안 차단된 스레드의 상태입니다.
       * 
       * 차단된 상태의 스레드가 Object를 호출한 후
       * 모니터 잠금이 동기화된 블록/메서드로 들어가거나
       * 동기화된 블록/메서드를 다시 입력하기를 기다리고 있습니다.
       * {@link Object#wait() Object.wait}
       */
      BLOCKED,
  
      /**
       * 대기 중인 스레드의 상태입니다.
       * 
       * 다음 메서드 중 하나를 호출하여 스레드가 대기 중입니다.
       * 
       *   {@link Object#wait() Object.wait} 타임아웃 없음
       *   {@link #join() Thread.join} 타임아웃 없음
       *   {@link LockSupport#park() LockSupport.park}
       *
       * 대기 상태의 스레드가 다른 특정 작업을 수행하기를 기다리고 있습니다.
       *
       * 예를 들어 개체에서 {@codeObject.wait()}을(를) 호출한 스레드가
       * 다른 스레드가 해당 개체에서
       * {@codeObject.notify()} 또는 {@codeObject.notifyAll()}을(를)
       * 호출하기를 기다리고 있습니다.
       * 
       * {@codeThread.join()}을(를) 호출한 스레드가
       * 종료되기를 기다리고 있습니다.
       */
      WAITING,
  
      /**
       * 지정된 대기 시간만큼 대기 중인 스레드 상태입니다.
       * 
       * 지정된 양의 대기 시간으로 다음 메서드 중 하나를 호출하여
       * 시간이 지정된 대기 상태에 있습니다.
       * 
       *   <li>{@link #sleep Thread.sleep}</li>
       *   <li>{@link Object#wait(long) Object.wait} with timeout</li>
       *   <li>{@link #join(long) Thread.join} with timeout</li>
       *   <li>{@link LockSupport#parkNanos LockSupport.parkNanos}</li>
       *   <li>{@link LockSupport#parkUntil LockSupport.parkUntil}</li>
       */
      TIMED_WAITING,
  
      /**
       * 종료된 스레드의 상태입니다.
       * 
       * 스레드가 실행을 완료했습니다.
       */
      TERMINATED;
  }
}
// =============================================================================
```

<br/><br/><br/>

### 쓰레드의 우선순위

---

- setProirity(int newProirity) 메서드로 우선 순위를 변경할 수 있다.
  - 최소 1, 최대 10 사이에서 우선 순위를 지정할 수 있다.
  - 1 미만 10 초과시 IllegalArgumentException 예외가 발생한다.
- getPriority() 메서드로 우선 순위를 조회할 수 있다.

```java
public class Thread implements Runnable {

  // ...

  public final void setPriority(int newPriority) {
    ThreadGroup g;
    checkAccess();
    if (newPriority > MAX_PRIORITY || newPriority < MIN_PRIORITY) {
      throw new IllegalArgumentException();
    }
    if((g = getThreadGroup()) != null) {
      if (newPriority > g.getMaxPriority()) {
        newPriority = g.getMaxPriority();
      }
      setPriority0(priority = newPriority);
    }
  }

  public final int getPriority() {
    return priority;
  }

  /**
   * 스레드가 가질 수 있는 최소 우선 순위입니다.
   */
  public static final int MIN_PRIORITY = 1;

  /**
   * 스레드에 할당된 기본 우선 순위입니다.
   */
  public static final int NORM_PRIORITY = 5;

  /**
   * 스레드가 가질 수 있는 최대 우선 순위입니다.
   */
  public static final int MAX_PRIORITY = 10;
}
// =============================================================================
public class ThreadBasic {

  public static void main(String[] args) {

    ThreadClass threadClass1 = new ThreadClass(1);
    ThreadClass threadClass2 = new ThreadClass(2);
    
    System.out.println("threadClass1 = " + threadClass1.getPriority());
    System.out.println("threadClass2 = " + threadClass2.getPriority());

    threadClass1.setPriority(1);
    threadClass2.setPriority(10);

    System.out.println("threadClass1 = " + threadClass1.getPriority());
    System.out.println("threadClass2 = " + threadClass2.getPriority());
  }
}
// =============================================================================
// threadClass1 = 5
// threadClass2 = 5
// 
// threadClass1 = 1
// threadClass2 = 10
```

<br/><br/><br/>

### 동기화

---

- https://p829911.tistory.com/9
- https://jammdev.tistory.com/163

- 여러 쓰레드가 동일한 리소스를 공유할 때 서로의 결과에 영향 주는 것을 방지 합니다.
- synchronized 키워드를 이용하여 임계 영역을 생성 한다.
- 임계 영역에서 쓰레드는 순서를 보장 받는다.
- 순서를 보장 받는 순서
  - 한 쓰레드가 임계 영역(synchronized)에서 lock을 받는다.
  - 다른 쓰레드가 작업 하려고 했더니 lock이 없어 대기한다.
  - 기존 쓰레드는 작업을 수행한 후 lock을 반환 한다.
  - 다른 쓰레드는 lock을 받아 작업을 수행한다.

> 임계 영역 없이 공유 리소스를 사용한다면...

```java
class Item {

    int itemCount = 999; // 공통 자원

    public int getItemCount() {
        return itemCount;
    }

    public void buy() throws InterruptedException {
        int count = itemCount;
        Thread.sleep(2000);
        itemCount = count + 1;
        System.out.println("구매 완료");
    }

    public void refund() throws InterruptedException {
        int count = itemCount;
        Thread.sleep(2000);
        itemCount = count - 1;
        System.out.println("환불 완료");
    }
}
// =============================================================================
class Shop {

    public static Item item = new Item();
}
// =============================================================================
class CustomerFoo extends Thread {

    @Override
    public void run() {

        try {
            Shop.item.buy(); // 구매
        } catch (InterruptedException e) { }

        System.out.println("Item의 재고 수량 : " + Shop.item.getItemCount());
    }
}
// =============================================================================
class CustomerBar extends Thread {

    @Override
    public void run() {

        try {
            Shop.item.refund(); // 환불
        } catch (InterruptedException e) { }

        System.out.println("Item의 재고 수량 : " + Shop.item.getItemCount());
    }
}
// =============================================================================
public class SyncTest {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("현재 상품 재고 개수 : " + Shop.item.getItemCount());

        CustomerFoo foo = new CustomerFoo(); // 구매
        CustomerBar bar = new CustomerBar(); // 환불

        bar.setPriority(10); // bar 고객의 우선순위를 10으로

        // 시작
        foo.start();
        bar.start();

        // 종료
        foo.join();
        bar.join();
    }
}
// =============================================================================
// 현재 상품 재고 개수 : 999
// 환불 완료
// 구매 완료
// Item의 재고 수량 : 1000
// Item의 재고 수량 : 1000
```

<br/>

> 임계 영역을 지정하여 리소스의 결과를 보장

- syncronized 키워드 사용

```java
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
// =============================================================================
class Shop {

    public static Item item = new Item();
}
// =============================================================================
class CustomerFoo extends Thread {

    @Override
    public void run() {

        try {
            Shop.item.buy(); // 구매
        } catch (InterruptedException e) { }

        System.out.println("Item의 재고 수량 : " + Shop.item.getItemCount());
    }
}
// =============================================================================
class CustomerBar extends Thread {

    @Override
    public void run() {

        try {
            Shop.item.refund(); // 환불
        } catch (InterruptedException e) { }

        System.out.println("Item의 재고 수량 : " + Shop.item.getItemCount());
    }
}
// =============================================================================
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
// =============================================================================
// 현재 상품 재고 개수 : 999
// 구매 완료
// Item의 재고 수량 : 1000
// 환불 완료
// Item의 재고 수량 : 999
```

<br/><br/><br/>

### 데드락

---

- 둘 이상의 쓰레드가 서로 lock을 호출하며 블록상태에 빠진 것 이다.
- 쓰레드가 lock을 기다리며 무한정으로 대기하는 상태가 된다.
  - Thread 1 locks A, waits for B
  - Thread 2 locks B, waits for A
- 발생 조건
  - 상호배제
  - 점유와 대기
  - 비선점
  - 환형 대기

```java
public class FirstThread extends Thread {

    @Override
    public void run() {

        synchronized (object1) {
            System.out.println("First Thread has object1 lock");
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("First Thread want to have object2's lock. so wait");

        synchronized (object2) {
            System.out.println("First Thread has object2 lock too");
        }
    }
}
// =============================================================================
public class SecondThread extends Thread {

  @Override
  public void run() {

    synchronized (object2) {
      System.out.println("Second Thread has object2 lock");
    }

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Second Thread want to have object1 lock, so wait");

    synchronized (object1){
      System.out.println("Second Thread has object1 lock too");
    }
  }
}
// =============================================================================
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
// =============================================================================
// Second Thread has object2 lock
// First Thread has object1 lock
// Second Thread want to have object1 lock, so wait
// First Thread want to have object2's lock. so wait
// Second Thread has object1 lock too
// First Thread has object2 lock too
```

<br/><br/><br/>
