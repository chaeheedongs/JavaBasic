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
final class FinalClass {

}


// final 클래스는 상속 불가
//class BasicClass extends FinalClass { }


class FinalBasicClass {

    // final 필드 변수
    final String str = "Hello Final!";

    // final 메서드
    final void print() {
        System.out.println("final 메서드는 오버라이딩 불가능");
    }

    public String getStr() {
        return str;
    }

//    public void setStr(String str) {
        // final 필드 변수는 값을 수정할 수 없음
//        this.str = str;
//    }
}


class FinalOtherClass extends FinalBasicClass {

//    @Override
//    void print() {
        // final 메서드는 오버라이딩 불가능
//    }
}


abstract class AbstractClass {

    // 필수로 선언해야 할 메서드 서술
    abstract void sonata();
}


// 부모 클래스
class Foo extends AbstractClass {

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
