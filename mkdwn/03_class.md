# 클래스

## 목차

---

- 클래스
- 메서드
- 생성자
- 생성자 정의
- 클래스의 인스턴스화 키워드 'new'
- this

---

<br/><br/><br/>

### 클래스

---

- 객체를 정의 하는 설계 도면 이다.
  - 붕어빵을 만드려면 기계가 있어야 하는데 클래스가 붕어빵을 만드는 기계가 된다.
- 클래스의 특성
  - 필드 변수
  - 생성자
  - 메서드

```java
// 붕어빵 기계
class FishBreadMachine {

    // 필드 변수
    private String taste;   // 맛
    private int price;      // 가격
    private int count;      // 개수


    // 생성자
    // 붕어빵 틀
    public FishBreadMachine() { }


    // 메서드
    public void intro() {
        System.out.println("This is fish bread machine");
    }
}
```

<br/><br/><br/>

### 메서드

---

- 클래스와 관련된 특정 작업을 수행 한다.
  - 붕어빵 기계는 붕어빵 틀을 이용하여 '붕어빵을 만든다.'
  - 위 내용에서 붕어빵을 만드는 기능을 수행 하는 것이 메서드 이다.

```java
// 붕어빵 기계
class FishBreadMachine {

  // 필드 변수
  private String taste;   // 맛
  private int price;      // 가격
  private int count;      // 개수

  // 메서드
  public void intro() {
    System.out.println("This is fish bread machine");
  }


  // 메서드
  // 남은 붕어빵의 개수를 확인
  public int getCount() {
    if (this.count < 0) {
      return 0;
    }
    return this.count;
  }


  // 메서드
  // 붕어빵을 만든다.
  public void makeFishBread() {
    if (this.count < 0) {
      this.count = 1;
    } else {
      this.count = count + 1;
    }
  }
}
```

<br/><br/><br/>

### 생성자

---

- 클래스를 초기화 하는 코드 이다.
  - 붕어빵 기계의 붕어빵 틀 이라고 생각 하면 된다.
- 생성자는 리턴 타입이 존재하지 않는다.
  - 접근제한자 생성자명() {} 으로 구성되어 있다.
- 생성자 명은 클래스 이름과 같아야 한다.
- 붕어빵 기계의 틀에 기본 적으로 팥 맛이 들어가 있다.
  - 만약 기본 생성자만 있거나 생성자 자체가 있지 않으면 컴파일러가 기본 생성자를 생성 한다.
  - 기본 생성자가 아닌 다른 생성자(팥빵 생성자)가 있다면 기본 생성자를 꼭 선언 해야 한다.

```java
// 붕어빵 기계
class FishBreadMachine {

    // 필드 변수
    private String taste;   // 맛
    private int price;      // 가격
    private int count;      // 개수


    // 기본 생성자
    // 붕어빵 틀
    public FishBreadMachine() { }

  
    // 팥빵 생성자
    // 팥빵 틀
    public FishBreadMachine(int price, int count) {
        this.taste = "RedBean"; // 기본적으로 팥 맛 이다.
        this.price = price;
        this.count = count;
    }
}
```

<br/><br/><br/>

### 클래스의 인스턴스화 키워드 'new'

---

- new 키워드로 클래스의 인스턴스를 생성할 수 있다.
- 클래스 클래스명 = new 생성자() 로 인스턴스를 생성 한다.
  - 붕어빵 틀을 붕어빵 기계에 조립한 것과 같다.
- new 키워드로 생성된 변수는 컴퓨터의 메모리에 객체로 할당 된다.

```java
package classes;

// 붕어빵 기계
class FishBreadMachine { }

public class ClassBasic {

    public static void main(String[] args) {

        // 클래스 초기화 (인스턴스 생성)
        // 붕어빵 기계에 붕어빵 틀을 조립한다.
        FishBreadMachine fishBreadMachine = new FishBreadMachine();
    }
}

```

<br/><br/><br/>

### this

---

- 생성된 인스턴스 자기 자신을 가르킨다.
- 클래스 내부 생성자와 메서드에서 사용할 수 있다.

```java
// 붕어빵 기계
class FishBreadMachine {

    // 필드 변수
    private String taste;   // 맛
    private int price;      // 가격
    private int count;      // 개수


    // 기본 생성자
    // 붕어빵 틀
    public FishBreadMachine() { }


    // 팥빵 생성자
    // 팥빵 틀
    public FishBreadMachine(int price, int count) {
        this.taste = "RedBean"; // 기본적으로 팥 맛 이다.
        this.price = price;
        this.count = count;
    }
}
```

<br/><br/><br/>

### 최종 코드

---

```java
package classes;

// 붕어빵 기계
class FishBreadMachine {

    // 필드 변수
    private String taste;   // 맛
    private int price;      // 가격
    private int count;      // 개수


    // 기본 생성자
    // 붕어빵 틀
    public FishBreadMachine() { }


    // 팥빵 생성자
    // 팥빵 틀
    public FishBreadMachine(int price, int count) {
        this.taste = "RedBean"; // 기본적으로 팥 맛 이다.
        this.price = price;
        this.count = count;
    }


    // 메서드
    public void intro() {
        System.out.println("This is fish bread machine");
    }


    // 메서드
    // 남은 붕어빵의 개수를 확인
    public int getCount() {
        if (this.count < 0) {
            return 0;
        }
        return this.count;
    }


    // 메서드
    // 붕어빵을 만든다.
    public void makeFishBread() {
        if (this.count < 0) {
            this.count = 1;
        } else {
            this.count = count + 1;
        }
    }
}


public class ClassBasic {

    public static void main(String[] args) {

        // 클래스 초기화(인스턴스 생성)
        // 붕어빵 기계에서 기본 생성자로 붕어빵 틀을 생성
        FishBreadMachine fishBreadMachine = new FishBreadMachine();

        // 클래스 초기화(인스턴스 생성)
        // 붕어빵 기계에서 팥빵 생성자로 팥 붕어빵 틀을 생성
        // FishBreadMachine fishBreadMachine = new FishBreadMachine(1000, 0);

        // 붕어빵을 만든다.
        fishBreadMachine.makeFishBread();

        // 붕어빵의 개수를 확인한다.
        int count = fishBreadMachine.getCount();
        System.out.println("붕어빵 개수 : " + count + " 개");
    }
}

```

<br/><br/><br/>