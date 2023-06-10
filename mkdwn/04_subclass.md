# 상속과 추상 그리고 final

## 목차

---

- 상속
- super
- 메서드 오버라이딩
- Dynamic Method Dispatch
- final
- 추상 클래스

---

<br/><br/><br/>

### 상속

---

- 부모님이 자식들에게 재산을 물려 주는 것과 같다.
- 부모 클래스의 자원을 자식 클래스가 사용하게 된다.
- 자식 클래스는 다중 상속이 불가능 하다.
  - 부모 입장에서 자식들에게 재산을 각각 물려줄 수 있다.
  - 자식 입장에서 부모는 하나 이다.
- 상속은 extends 키워드를 사용 한다.
  - class 자식 extends 부모 { }

```java
// 부모 클래스
class foo {  }


// 자식 클래스
class Bar extends foo {  }


// 자식 클래스
class Baz extends foo {  }
// =============================
// 다중 상속 안됨
// class Baz extends Foo, Bar { }
```

<br/><br/><br/>

### super

---

- 부모님의 재산을 물려받은 자식이 부모의 재산을 사용하는 것과 같다.
- super()
  - 자식 생성자의 맨 처음 줄에 작성해야 한다.
  - 부모님의 생성자를 호출한다.
- super
  - 자식의 생성자에서 작성해야 한다.
  - 부모님의 필드를 호출한다.

```java
// 부모 클래스
class Foo {

    public int parentAvgTall;   // 부모님의 평균 키
    public int parentAvgWeight; // 부모님의 평균 몸무게

    public Foo() {
        this.parentAvgTall = 170;
        this.parentAvgWeight = 60;

        System.out.println("   부모님의 평균 키 : " + this.parentAvgTall);
        System.out.println("부모님의 평균 몸무게 : " + this.parentAvgWeight);
    }
}


// 자식 클래스
class Bar extends Foo {

    public int barSelfTall;   // 나의 키
    public int barSelfWeight; // 나의 몸무게

    public Bar() {
        super(); // 부모님의 생성자를 호출

        this.barSelfTall = 175;
        this.barSelfWeight = 70;

        System.out.println("   Bar의 키 : " + this.barSelfTall);
        System.out.println("Bar의 몸무게 : " + this.barSelfWeight);
    }
}


// 자식 클래스
class Baz extends Foo {

    public int bazSelfTall;   // 나의 키
    public int bazSelfWeight; // 나의 몸무게

    public Baz() {
        this.bazSelfTall = 160;
        this.bazSelfWeight = 50;

        System.out.println("   부모님의 평균 키 : " + super.parentAvgTall);
        System.out.println("부모님의 평균 몸무게 : " + super.parentAvgWeight);
        
        System.out.println("   Baz의 키 : " + this.bazSelfTall);
        System.out.println("Baz의 몸무게 : " + this.bazSelfWeight);
    }
}
```

<br/><br/><br/>

### 메소드 오버라이딩

---

- 부모님의 메서드를 자식들이 재정의 하여 사용하는 것 이다.
- 예를들어 부모님의 자동차를 자식이 물려 받아 새로 꾸며 사용하는 것 이다.
  - 하지만 자동차의 이름은 그대로 이다.
- 오버라이딩은 재정의 하여 사용 하는 것 이다.
- 부모님의 메서드와 오버라이딩한 자식의 메서드의 메서드 선언부는 같아야 한다.
  - 리턴형식 메서드명 (매개변수) { } 모두 같아야 한다.
- 보무님의 접근제한자보다 낮은 범위로 선언할 수 없다.

```java
// 부모 클래스
class Foo {

  public int parentAvgTall;   // 부모님의 평균 키
  public int parentAvgWeight; // 부모님의 평균 몸무게

  public Foo() {
    this.parentAvgTall = 170;
    this.parentAvgWeight = 60;

    System.out.println("    부모님의 평균 키 : " + this.parentAvgTall);
    System.out.println("부모님의 평균 몸무게 : " + this.parentAvgWeight);
  }

  public void sonata() {
    System.out.println("Foo의 소나타 자동차 이다.");
  }
}


// 자식 클래스
class Bar extends Foo {

  public int barSelfTall;   // 나의 키
  public int barSelfWeight; // 나의 몸무게

  public Bar() {
    super(); // 부모님의 생성자를 호출

    this.barSelfTall = 175;
    this.barSelfWeight = 70;

    System.out.println("    Bar의 키 : " + this.barSelfTall);
    System.out.println("Bar의 몸무게 : " + this.barSelfWeight);
  }

  @Override
  public void sonata() {
    System.out.println("부모님께 물려 받은 Bar의 소나타 이다.");
  }
}


// 자식 클래스
class Baz extends Foo {

  public int bazSelfTall;   // 나의 키
  public int bazSelfWeight; // 나의 몸무게

  public Baz() {
    this.bazSelfTall = 160;
    this.bazSelfWeight = 50;

    System.out.println("    Baz의 키 : " + this.bazSelfTall);
    System.out.println("Baz의 몸무게 : " + this.bazSelfWeight);

    System.out.println("    부모님의 평균 키 : " + super.parentAvgTall);
    System.out.println("부모님의 평균 몸무게 : " + super.parentAvgWeight);
  }

  @Override
  public void sonata() {
    System.out.println("부모님께 물려 받은 Baz의 소나타 이다.");
  }
}
```

<br/><br/><br/>

### Dynamic Method Dispatch

---

- 런타임시 어떤 클래스를 사용할지 지정하는 방법이다.
- 런타임 시점에 역할을 분리할 수 있다.
  - 역할을 분리하면 각 상황에 맞게 로직을 분리할 수 있다.
  - 상황에 알맞게 로직을 바꾸어 선언해 줄 수 있다.
- 상속 관계여야 한다.
- 부모님의 자원을 상속 받은 자식 클래스는 부모님을 따라갈 수 있다.
- 반대되는 말은 Static Method Dispatch 이다.
  - 런타임시 자기 자신을 그대로 지정하는 방법이다.

```java
package subclasses;


// 부모 클래스
class Foo {

    public void sonata() {
        System.out.println("Foo의 소나타 자동차 이다.");
    }
}


// 자식 클래스
class Bar extends Foo {

    @Override
    public void sonata() {
        System.out.println("부모님께 물려 받은 Bar의 소나타 이다.");
    }
}


// 자식 클래스
class Baz extends Foo {

    @Override
    public void sonata() {
        System.out.println("부모님께 물려 받은 Baz의 소나타 이다.");
    }
}


public class SubClassBasic {

    public static void main(String[] args) {

        // Dynamic Method Dispatch
        Foo fooBar = new Bar();
        Foo fooBaz = new Baz();

        fooBar.sonata();
        fooBaz.sonata();
    }
}
// =============================================================================
// 부모님께 물려 받은 Bar의 소나타 이다.
// 부모님께 물려 받은 Baz의 소나타 이다.
```

<br/><br/><br/>

### final

---

- 고유함을 나타낸다.
- 상속 및 오버라이딩이 불가능하다.
- 방식
  - final 클래스
  - final 필드 변수
  - final 메서드

```java
// final class
final class finalClass {
    
}

// final 클래스는 상속 불가
//class basicClass extends finalClass { }

class finalBasicClass {

    // final 필드 변수
    final String str = "Hello Final!";

    // final 메서드
    final void print() {
        System.out.println("final 메서드는 오버라이딩 불가능");
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        // final 필드 변수는 값을 수정할 수 없음
        this.str = str;
    }
}

class finalOtherClass extends finalBasicClass {

    @Override
    void print() {
        // 오버라이딩 불가능
    }
}
```

<br/><br/><br/>

### 추상 클래스

---

- 추상 클래스는 꼭 필요한 기능을 모아 놓은 곳 이다.
- 보통 상속시 부모 클래스에 추상 클래스를 상속 시킨다.
- 상속받은 부모 클래스는 상속 클래스의 내용을 무조건 재정의 해야 한다.
- class 앞에 abstract를 붙인다.

```java
package subclasses;

// =============================================================================

abstract class abstractClass {

    // 필수로 선언해야 할 메서드
    abstract void sonata();
}


// 부모 클래스
class Foo extends abstractClass {

    @Override
    public void sonata() {
        System.out.println("Foo의 소나타 자동차 이다.");
    }
}


// 자식 클래스
class Bar extends Foo {

    @Override
    public void sonata() {
        System.out.println("부모님께 물려 받은 Bar의 소나타 이다.");
    }
}


// 자식 클래스
class Baz extends Foo {

    @Override
    public void sonata() {
        System.out.println("부모님께 물려 받은 Baz의 소나타 이다.");
    }
}


// =============================================================================


public class SubClassBasic {

    public static void main(String[] args) {

        // Dynamic Method Dispatch
        Foo fooBar = new Bar();
        Foo fooBaz = new Baz();

        fooBar.sonata();
        fooBaz.sonata();
    }
}

```

<br/><br/><br/>

### 최종 코드

---

```java
package subclasses;

// 부모 클래스
//class Foo {  }


// 자식 클래스
//class Bar extends Foo {  }


// 자식 클래스
//class Baz extends Foo {  }


// 다중 상속 안됨
// class Baz extends Foo, Bar { }

// =============================================================================

// final class
final class finalClass {
    
}


// final 클래스는 상속 불가
//class basicClass extends finalClass { }


class finalBasicClass {

    // final 필드 변수
    final String str = "Hello Final!";

    // final 메서드
    final void print() {
        System.out.println("final 메서드는 오버라이딩 불가능");
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        // final 필드 변수는 값을 수정할 수 없음
        this.str = str;
    }
}


class finalOtherClass extends finalBasicClass {

//    @Override
//    void print() {
        // 오버라이딩 불가능
//    }
}


abstract class abstractClass {

    // 필수로 선언해야 할 메서드
    abstract void sonata();
}


// 부모 클래스
class Foo extends abstractClass {

    public int parentAvgTall;   // 부모님의 평균 키
    public int parentAvgWeight; // 부모님의 평균 몸무게

    public Foo() {
        this.parentAvgTall = 170;
        this.parentAvgWeight = 60;

        System.out.println("    부모님의 평균 키 : " + this.parentAvgTall);
        System.out.println("부모님의 평균 몸무게 : " + this.parentAvgWeight);
    }

    @Override
    public void sonata() {
        System.out.println("Foo의 소나타 자동차 이다.");
    }
}


// 자식 클래스
class Bar extends Foo {

    public int barSelfTall;   // 나의 키
    public int barSelfWeight; // 나의 몸무게

    public Bar() {
        super(); // 부모님의 생성자를 호출

        this.barSelfTall = 175;
        this.barSelfWeight = 70;

        System.out.println("    Bar의 키 : " + this.barSelfTall);
        System.out.println("Bar의 몸무게 : " + this.barSelfWeight);
    }

    @Override
    public void sonata() {
        System.out.println("부모님께 물려 받은 Bar의 소나타 이다.");
    }
}


// 자식 클래스
class Baz extends Foo {

    public int bazSelfTall;   // 나의 키
    public int bazSelfWeight; // 나의 몸무게

    public Baz() {
        this.bazSelfTall = 160;
        this.bazSelfWeight = 50;

        System.out.println("    Baz의 키 : " + this.bazSelfTall);
        System.out.println("Baz의 몸무게 : " + this.bazSelfWeight);

        System.out.println("    부모님의 평균 키 : " + super.parentAvgTall);
        System.out.println("부모님의 평균 몸무게 : " + super.parentAvgWeight);
    }

    @Override
    public void sonata() {
        System.out.println("부모님께 물려 받은 Baz의 소나타 이다.");
    }
}


// =============================================================================


public class SubClassBasic {

    public static void main(String[] args) {

//        Bar bar = new Bar();
//        Baz baz = new Baz();

        // Dynamic Method Dispatch
        Foo fooBar = new Bar();
        Foo fooBaz = new Baz();

        fooBar.sonata();
        fooBaz.sonata();
    }
}
```