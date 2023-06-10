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
