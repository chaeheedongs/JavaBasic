# 인터페이스

## 목차

---

- 인터페이스 정의
- 인터페이스 구현
- 구현체 사용 방법
- 인터페이스 상속
- 인터페이스 default 메서드 (Java8)
- 인터페이스 static 메서드  (Java8)
- 인터페이스 private 메서드 (Java9)

---

<br/><br/><br/>

### 인터페이스 정의

---

- 붕어빵 기계의 설계도 이다.
- 여러 붕어빵 체인점들이 붕어빵 기계의 설계도를 보고 설계할 수 있도록 도와 준다.
- 각 체인점들은 기능의 이름을 동일하고 기능의 내용은 입맛대로 설계할 수 있다.
- 각 체인점들은 본사의 설계서에 있는 모든 기능을 구현 해야 한다.
  - 붕어빵 기계의 기능을 빼먹으면 붕어빵 기계는 동작하지 않는다.
- 붕어빵 본사는 기능의 이름으로 각 체인점들을 점검할 수 있다.
  - 본사는 체인점의 붕어빵 기계가 고장났을 때 유지보수가 쉬워 진다.
- class 키워드 대신 interface 키워드를 사용 한다.
- 접근제한자는 public 또는 default 만 사용할 수 있다.

```java
public interface FishBurnMachineDesign {

}
```

<br/><br/><br/>

### 인터페이스 구현

---

- 인터페이스는 상수 필드, 추상 메서드를 소유할 수 있다.
  - 상수 필드의 static final 은 생략 가능 하다.
  - 추상 메서드의 abstract 는 생략 가능 하다.
    - 컴파일 단계에서 컴파일 단계에서 추가 된다.

```java
public interface FishBurnMachineDesign {

  int ROAST_TIME_SET = 3;

  // static final 생략 가능
  static final String FISH_BURN_MACHINE_NAME = "붕어빵 기계";



  String taste();     // 맛
  int roastTime();    // 굽기 시간 조절

  // abstract 생략 가능
  abstract int firePower();    // 불의 강도
  abstract int electricityConsumption(); // 전기 소모량
}
```

<br/><br/><br/>

### 구현체 사용 방법

---

- implements 키워드를 이용하여 구현체를 생성 한다.
- 구현체는 인터페이스의 메서드를 전부 오버라이딩 받아 재정의 한다.
- 붕어빵 기계 디자인을 기반으로 팥, 피자 붕어빵 가게가 기계를 조립 했다.
- 붕어빵 가게는 기계를 만들어 붕어빵을 생산할 수 있다.

```java
// 인터페이스
public interface FishBurnMachineDesign {

    int ROAST_TIME_SET = 3;

    // static final 생략 가능
    static final String FISH_BURN_MACHINE_NAME = "붕어빵 기계";



    String taste();     // 맛
    int roastTime();    // 굽기 시간 조절

    // abstract 생략 가능
    abstract int firePower();    // 불의 강도
    abstract int electricityConsumption(); // 전기 소모량
}
//==============================================================================
// 팥 붕어빵 가게 인터페이스 구현체
public class BeanFishBurnShop implements FishBurnMachineDesign {

  @Override
  public String taste() {
    return "팥빵";
  }

  @Override
  public int roastTime() {
    return 5; // 굽는 시간
  }

  @Override
  public int firePower() {
    return 8; // 1부터 10까지라면
  }

  @Override
  public int electricityConsumption() {
    return 40; // 5분동안 불의 강도 8로 붕어빵 굽는 기준
  }
}
//==============================================================================
// 피자 붕어빵 가게 인터페이스 구현체
public class PizzaFishBurnShop implements FishBurnMachineDesign {

  @Override
  public String taste() {
    return "피자";
  }

  @Override
  public int roastTime() {
    return 7; // 굽는 시간
  }

  @Override
  public int firePower() {
    return 5; // 1부터 10까지라면
  }

  @Override
  public int electricityConsumption() {
    return 35; // 7분동안 불의 강도 5로 붕어빵 굽는 기준
  }
}
//==============================================================================
// 붕어빵 가게 구현체 사용 
public class FishBurnShop {

  public static void main(String[] args) {

    BeanFishBurnShop beanShop = new BeanFishBurnShop();
    String beanTaste  = beanShop.taste();
    int beanRoastTime = beanShop.roastTime();
    int beanFirePower = beanShop.firePower();
    int beanElectricityConsumption = beanShop.electricityConsumption();

    System.out.println("beanTaste : " + beanTaste);
    System.out.println("beanRoastTime : " + beanRoastTime);
    System.out.println("beanFirePower : " + beanFirePower);
    System.out.println("beanElectricityConsumption : " + beanElectricityConsumption);

    PizzaFishBurnShop pizzaShop = new PizzaFishBurnShop();
    String pizzaTaste  = pizzaShop.taste();
    int pizzaRoastTime = pizzaShop.roastTime();
    int pizzaFirePower = pizzaShop.firePower();
    int pizzaElectricityConsumption = pizzaShop.electricityConsumption();

    System.out.println("pizzaTaste : " + pizzaTaste);
    System.out.println("pizzaRoastTime : " + pizzaRoastTime);
    System.out.println("pizzaFirePower : " + pizzaFirePower);
    System.out.println("pizzaElectricityConsumption : " + pizzaElectricityConsumption);
  }
}
//==============================================================================
// beanTaste : 팥빵
// beanRoastTime : 5
// beanFirePower : 8
// beanElectricityConsumption : 40
// pizzaTaste : 피자
// pizzaRoastTime : 7
// pizzaFirePower : 5
// pizzaElectricityConsumption : 35
```

<br/><br/><br/>

### 인터페이스 상속

---

- 인터페이스는 또 다른 인터페이스를 상속 받을 수 있다.
  - extends 키워드를 이용하여 상속 받는다.
- 인터페이스는 다중 상속이 가능하다.
- 자식 인터페이스는 부모 인터페이스의 기능을 물려 받는다.
- 자식 인터페이스의 구현체들은 부모의 기능을 구현 해야 한다.
- 붕어빵 본사 에서 시그니처 메뉴를 고민 했다.
- 본사는 시그니처 메뉴를 디자인 하여 기존 붕어빵 설계서에 추가 하였다.
- 가게들은 본사의 지침으로 시그니처 레시피를 붕어빵 기계에 추가 하였다.
- 팥, 피자 붕어빵 가게에서 본사의 시그니처 메뉴를 출시 하였다.

```java
// 붕어빵 본사가 시그니처 디자인을 출시
public interface SignatureMachineDesign{

    abstract String signatureBurn();
}
//==============================================================================
// 인터페이스에 시그니처 메뉴 추가
public interface FishBurnMachineDesign extends SignatureMachineDesign {

  int ROAST_TIME_SET = 3;

  // static final 생략 가능
  static final String FISH_BURN_MACHINE_NAME = "붕어빵 기계";



  String taste();     // 맛
  int roastTime();    // 굽기 시간 조절

  // abstract 생략 가능
  abstract int firePower();    // 불의 강도
  abstract int electricityConsumption(); // 전기 소모량
}
//==============================================================================
// 팥 붕어빵 가게 인터페이스 구현체에 시그니처 메뉴 추가
public class BeanFishBurnShop implements FishBurnMachineDesign {

  @Override
  public String taste() {
    return "팥빵";
  }

  @Override
  public int roastTime() {
    return 5; // 굽는 시간
  }

  @Override
  public int firePower() {
    return 8; // 1부터 10까지라면
  }

  @Override
  public int electricityConsumption() {
    return 40; // 5분동안 불의 강도 8로 붕어빵 굽는 기준
  }

  @Override
  public String signatureBurn() {
    return "시그니처 붕어빵";
  }
}
//==============================================================================
// 피자 붕어빵 가게 인터페이스 구현체에 시그니처 메뉴 추가
public class PizzaFishBurnShop implements FishBurnMachineDesign {

  @Override
  public String taste() {
    return "피자";
  }

  @Override
  public int roastTime() {
    return 7; // 굽는 시간
  }

  @Override
  public int firePower() {
    return 5; // 1부터 10까지라면
  }

  @Override
  public int electricityConsumption() {
    return 35; // 7분동안 불의 강도 5로 붕어빵 굽는 기준
  }

  @Override
  public String signatureBurn() {
    return "시그니처 붕어빵";
  }
}
//==============================================================================
// 붕어빵 가게 구현체들이 시그니처 메뉴를 출시 
public class FishBurnShop {

  public static void main(String[] args) {

    BeanFishBurnShop beanShop = new BeanFishBurnShop();
    String beanTaste  = beanShop.taste();
    int beanRoastTime = beanShop.roastTime();
    int beanFirePower = beanShop.firePower();
    int beanElectricityConsumption = beanShop.electricityConsumption();
    String beanSignatureBurn = beanShop.signatureBurn();

    System.out.println("beanTaste : " + beanTaste);
    System.out.println("beanRoastTime : " + beanRoastTime);
    System.out.println("beanFirePower : " + beanFirePower);
    System.out.println("beanElectricityConsumption : " + beanElectricityConsumption);
    System.out.println("beanSignatureBurn : " + beanSignatureBurn);

    PizzaFishBurnShop pizzaShop = new PizzaFishBurnShop();
    String pizzaTaste  = pizzaShop.taste();
    int pizzaRoastTime = pizzaShop.roastTime();
    int pizzaFirePower = pizzaShop.firePower();
    int pizzaElectricityConsumption = pizzaShop.electricityConsumption();
    String pizzaSignatureBurn = pizzaShop.signatureBurn();

    System.out.println("pizzaTaste : " + pizzaTaste);
    System.out.println("pizzaRoastTime : " + pizzaRoastTime);
    System.out.println("pizzaFirePower : " + pizzaFirePower);
    System.out.println("pizzaElectricityConsumption : " + pizzaElectricityConsumption);
    System.out.println("pizzaSignatureBurn : " + pizzaSignatureBurn);
  }
}
//==============================================================================
// beanTaste : 팥빵
// beanRoastTime : 5
// beanFirePower : 8
// beanElectricityConsumption : 40
// beanSignatureBurn : 시그니처 붕어빵
// pizzaTaste : 피자
// pizzaRoastTime : 7
// pizzaFirePower : 5
// pizzaElectricityConsumption : 35
// pizzaSignatureBurn : 시그니처 붕어빵
```

<br/><br/><br/>

### 인터페이스 default 메서드 ( Java8 )

---

- 자바8 부터 인터페이스의 메서드에 default 접근제한자를 사용할 수 있다.
- default 메서드는 인터페이스에서 로직을 구현 한다.
- 구현된 default 메서드는 구현체에서 오버라이딩을 하거나 안해도 된다.
  - 오버라이딩을 하지 않으면 인터페이스의 로직을 활용하게 된다.
  - 오버라이딩을 하게 된다면 재정의 하여 사용할 수 있다.
- 구현체를 구현한 객체에서 인터페이스의 default 메서드를 호출 한다.
- 본사에서 각 가게들의 이름이 걸린 간판을 제작해 준다고 한다.
- 본사는 붕어빵 기계 설계서에 가게 간판 신청서를 추가 하였다.
- 팥 붕어빵 가게는 본사의 지침에 추가로 '30년 전통' 문구를 추가 했다.
- 피자 붕어빵 가게는 본사의 지침에 그냥 따르기로 했다.

```java
public interface FishBurnMachineDesign extends SignatureMachineDesign {

    int ROAST_TIME_SET = 3;

    // static final 생략 가능
    static final String FISH_BURN_MACHINE_NAME = "붕어빵 기계";



    String taste();     // 맛
    int roastTime();    // 굽기 시간 조절

    // abstract 생략 가능
    abstract int firePower();    // 불의 강도
    abstract int electricityConsumption(); // 전기 소모량

    // 가게 간판 만들기
    default String shopName(String name) {
        if (name != null && name.trim().length() != 0) {
            return name + " 붕어빵 가게";
        } else {
            return "신규 붕어빵 가게";
        }
    }
}
//==============================================================================
// 팥 붕어빵 가게는 '30년 전통' 문구를 추가 하였다.
public class BeanFishBurnShop implements FishBurnMachineDesign {

  @Override
  public String taste() {
    return "팥빵";
  }

  @Override
  public int roastTime() {
    return 5; // 굽는 시간
  }

  @Override
  public int firePower() {
    return 8; // 1부터 10까지라면
  }

  @Override
  public int electricityConsumption() {
    return 40; // 5분동안 불의 강도 8로 붕어빵 굽는 기준
  }

  @Override
  public String signatureBurn() {
    return "시그니처 붕어빵";
  }
  
  @Override
  public String shopName(String name) {
    if (name != null && name.trim().length() != 0) {
      return "30년 전통 " + name + " 붕어빵 가게";
    } else {
      return "신규 붕어빵 가게";
    }
  }
}
//==============================================================================
// 피자 붕어빵 가게는 본사가 지정해준 이름으로 간판을 만들기로 하였다.
public class PizzaFishBurnShop implements FishBurnMachineDesign {

  @Override
  public String taste() {
    return "피자";
  }

  @Override
  public int roastTime() {
    return 7; // 굽는 시간
  }

  @Override
  public int firePower() {
    return 5; // 1부터 10까지라면
  }

  @Override
  public int electricityConsumption() {
    return 35; // 7분동안 불의 강도 5로 붕어빵 굽는 기준
  }

  @Override
  public String signatureBurn() {
    return "시그니처 붕어빵";
  }
}
//==============================================================================
// 가게들 간판을 추가 하였음
public class FishBurnShop {

  public static void main(String[] args) {

    BeanFishBurnShop beanShop = new BeanFishBurnShop();
    String beanTaste  = beanShop.taste();
    int beanRoastTime = beanShop.roastTime();
    int beanFirePower = beanShop.firePower();
    int beanElectricityConsumption = beanShop.electricityConsumption();
    String beanSignatureBurn = beanShop.signatureBurn();
    String beanShopName = beanShop.shopName("팥");

    System.out.println("beanShopName : " + beanShopName);
    System.out.println("beanTaste : " + beanTaste);
    System.out.println("beanRoastTime : " + beanRoastTime);
    System.out.println("beanFirePower : " + beanFirePower);
    System.out.println("beanElectricityConsumption : " + beanElectricityConsumption);
    System.out.println("beanSignatureBurn : " + beanSignatureBurn);

    PizzaFishBurnShop pizzaShop = new PizzaFishBurnShop();
    String pizzaTaste  = pizzaShop.taste();
    int pizzaRoastTime = pizzaShop.roastTime();
    int pizzaFirePower = pizzaShop.firePower();
    int pizzaElectricityConsumption = pizzaShop.electricityConsumption();
    String pizzaSignatureBurn = pizzaShop.signatureBurn();
    String pizzaShopName = pizzaShop.shopName("피자");

    System.out.println("pizzaShopName : " + pizzaShopName);
    System.out.println("pizzaTaste : " + pizzaTaste);
    System.out.println("pizzaRoastTime : " + pizzaRoastTime);
    System.out.println("pizzaFirePower : " + pizzaFirePower);
    System.out.println("pizzaElectricityConsumption : " + pizzaElectricityConsumption);
    System.out.println("pizzaSignatureBurn : " + pizzaSignatureBurn);
  }
}
//==============================================================================
// beanShopName : 30년 전통 팥 붕어빵 가게
// beanTaste : 팥빵
// beanRoastTime : 5
// beanFirePower : 8
// beanElectricityConsumption : 40
// beanSignatureBurn : 시그니처 붕어빵
// pizzaShopName : 피자 붕어빵 가게
// pizzaTaste : 피자
// pizzaRoastTime : 7
// pizzaFirePower : 5
// pizzaElectricityConsumption : 35
// pizzaSignatureBurn : 시그니처 붕어빵
```

<br/><br/><br/>

### 인터페이스 static 메서드 ( Java8 )

---

- 자바8 부터 인터페이스의 메서드에 static을 사용할 수 있다.
- 구현체에서 오버라이딩을 받을 수 없다.
- 인터페이스 본인을 호출하여 해당 메서드를 사용할 수 있다.
- 붕어빵 본사는 이제 막 사업을 시작해서 아직 이름이 없었다.
- 가게들은 이름이 있지만 정작 본사는 이름이 없었다.
- 본사는 본사 이름 지어 붕어빵 기계 설계서에 워터마킹 작업을 하였다.
- 붕어빵 기계를 이용 하려면 붕어빵 본사에 문의해야 한다.

```java
// 본사 이름을 붕어빵 기계의 설계도에 워터마킹
public interface FishBurnMachineDesign extends SignatureMachineDesign {

    int ROAST_TIME_SET = 3;

    // static final 생략 가능
    static final String FISH_BURN_MACHINE_NAME = "붕어빵 기계";



    String taste();     // 맛
    int roastTime();    // 굽기 시간 조절

    // abstract 생략 가능
    abstract int firePower();    // 불의 강도
    abstract int electricityConsumption(); // 전기 소모량

    // 가게 간판 만들기
    default String shopName(String name) {
        if (name != null && name.trim().length() != 0) {
            return name + " 붕어빵 가게";
        } else {
            return "신규 붕어빵 가게";
        }
    }

    static String headOfficeName() {
        return "붕어빵 본사";
    }
}
//==============================================================================
// 본사 이름 생성
public class FishBurnShop {

  public static void main(String[] args) {

    String headOfficeName = FishBurnMachineDesign.headOfficeName();
    System.out.println("headOfficeName = " + headOfficeName);

    BeanFishBurnShop beanShop = new BeanFishBurnShop();
    String beanTaste  = beanShop.taste();
    int beanRoastTime = beanShop.roastTime();
    int beanFirePower = beanShop.firePower();
    int beanElectricityConsumption = beanShop.electricityConsumption();
    String beanSignatureBurn = beanShop.signatureBurn();
    String beanShopName = beanShop.shopName("팥");

    System.out.println("beanShopName : " + beanShopName);
    System.out.println("beanTaste : " + beanTaste);
    System.out.println("beanRoastTime : " + beanRoastTime);
    System.out.println("beanFirePower : " + beanFirePower);
    System.out.println("beanElectricityConsumption : " + beanElectricityConsumption);
    System.out.println("beanSignatureBurn : " + beanSignatureBurn);

    PizzaFishBurnShop pizzaShop = new PizzaFishBurnShop();
    String pizzaTaste  = pizzaShop.taste();
    int pizzaRoastTime = pizzaShop.roastTime();
    int pizzaFirePower = pizzaShop.firePower();
    int pizzaElectricityConsumption = pizzaShop.electricityConsumption();
    String pizzaSignatureBurn = pizzaShop.signatureBurn();
    String pizzaShopName = pizzaShop.shopName("피자");

    System.out.println("pizzaShopName : " + pizzaShopName);
    System.out.println("pizzaTaste : " + pizzaTaste);
    System.out.println("pizzaRoastTime : " + pizzaRoastTime);
    System.out.println("pizzaFirePower : " + pizzaFirePower);
    System.out.println("pizzaElectricityConsumption : " + pizzaElectricityConsumption);
    System.out.println("pizzaSignatureBurn : " + pizzaSignatureBurn);
  }
}
//==============================================================================
// headOfficeName = 붕어빵 본사
// beanShopName : 30년 전통 팥 붕어빵 가게
// beanTaste : 팥빵
// beanRoastTime : 5
// beanFirePower : 8
// beanElectricityConsumption : 40
// beanSignatureBurn : 시그니처 붕어빵
// pizzaShopName : 피자 붕어빵 가게
// pizzaTaste : 피자
// pizzaRoastTime : 7
// pizzaFirePower : 5
// pizzaElectricityConsumption : 35
// pizzaSignatureBurn : 시그니처 붕어빵
```

<br/><br/><br/>

### 인터페이스 private 메서드 ( Java9 )

---

- 자바9 부터 인터페이스의 메서드에 private 접근제한자를 사용할 수 있다.
- private 접근제한자 기준으로 인터페이스 내부에서만 사용할 수 있다.
  - 외부에서 수정 불가
- 인터페이스의 default 메서드나 static 메서드에 활용 된다.
- private 메서드나 private static 메서드를 생성할 수 있다.
- 본사는 사명을 변경하기로 하였다.
  - 사명 변경으로 인하여 가게들의 이름도 변경 된다.
  - 본사의 지침대로 간판을 만든 가게들 한정으로 간판을 변경 해준다.

```java
// 본사와 가게들의 신규 간판 이름을 본사가 지정 했다.
// 본사 이외엔 절대 바꿀 수 없다.
public interface FishBurnMachineDesign extends SignatureMachineDesign {

  int ROAST_TIME_SET = 3;

  // static final 생략 가능
  static final String FISH_BURN_MACHINE_NAME = "붕어빵 기계";



  String taste();     // 맛
  int roastTime();    // 굽기 시간 조절

  // abstract 생략 가능
  abstract int firePower();    // 불의 강도
  abstract int electricityConsumption(); // 전기 소모량

  // 가게 간판 만들기
  default String shopName(String name) {
    String firstName = shopFirstName();
    if (name != null && name.trim().length() != 0) {
      return firstName + name + " 붕어빵 가게";
    } else {
      return firstName + "신규 붕어빵 가게";
    }
  }

  static String headOfficeName() {
    String firstName = headOfficeFirstName();
    return firstName + "붕어빵 본사";
  }

  private String shopFirstName() {
    return "옛 추억 ";
  }

  private static String headOfficeFirstName() {
    return "옛 추억 ";
  }
}
//==============================================================================
// 팥 붕어빵 가게는 기존 간판을 이용한다.
public class BeanFishBurnShop implements FishBurnMachineDesign {

  @Override
  public String taste() {
    return "팥빵";
  }

  @Override
  public int roastTime() {
    return 5; // 굽는 시간
  }

  @Override
  public int firePower() {
    return 8; // 1부터 10까지라면
  }

  @Override
  public int electricityConsumption() {
    return 40; // 5분동안 불의 강도 8로 붕어빵 굽는 기준
  }

  @Override
  public String signatureBurn() {
    return "시그니처 붕어빵";
  }

  @Override
  public String shopName(String name) {
    if (name != null && name.trim().length() != 0) {
      return "30년 전통 " + name + " 붕어빵 가게";
    } else {
      return "신규 붕어빵 가게";
    }
  }
}
//==============================================================================
// 피자 붕어빵 가게는 가만히 있어도 본사에서 간판을 바꾸어 준다.
public class PizzaFishBurnShop implements FishBurnMachineDesign {

  @Override
  public String taste() {
    return "피자";
  }

  @Override
  public int roastTime() {
    return 7; // 굽는 시간
  }

  @Override
  public int firePower() {
    return 5; // 1부터 10까지라면
  }

  @Override
  public int electricityConsumption() {
    return 35; // 7분동안 불의 강도 5로 붕어빵 굽는 기준
  }

  @Override
  public String signatureBurn() {
    return "시그니처 붕어빵";
  }
}
//==============================================================================
// 변경된 간판을 모두 사용한다.
public class FishBurnShop {

  public static void main(String[] args) {

    String headOfficeName = FishBurnMachineDesign.headOfficeName();
    System.out.println("headOfficeName = " + headOfficeName);

    BeanFishBurnShop beanShop = new BeanFishBurnShop();
    String beanTaste  = beanShop.taste();
    int beanRoastTime = beanShop.roastTime();
    int beanFirePower = beanShop.firePower();
    int beanElectricityConsumption = beanShop.electricityConsumption();
    String beanSignatureBurn = beanShop.signatureBurn();
    String beanShopName = beanShop.shopName("팥");

    System.out.println("beanShopName : " + beanShopName);
    System.out.println("beanTaste : " + beanTaste);
    System.out.println("beanRoastTime : " + beanRoastTime);
    System.out.println("beanFirePower : " + beanFirePower);
    System.out.println("beanElectricityConsumption : " + beanElectricityConsumption);
    System.out.println("beanSignatureBurn : " + beanSignatureBurn);

    PizzaFishBurnShop pizzaShop = new PizzaFishBurnShop();
    String pizzaTaste  = pizzaShop.taste();
    int pizzaRoastTime = pizzaShop.roastTime();
    int pizzaFirePower = pizzaShop.firePower();
    int pizzaElectricityConsumption = pizzaShop.electricityConsumption();
    String pizzaSignatureBurn = pizzaShop.signatureBurn();
    String pizzaShopName = pizzaShop.shopName("피자");

    System.out.println("pizzaShopName : " + pizzaShopName);
    System.out.println("pizzaTaste : " + pizzaTaste);
    System.out.println("pizzaRoastTime : " + pizzaRoastTime);
    System.out.println("pizzaFirePower : " + pizzaFirePower);
    System.out.println("pizzaElectricityConsumption : " + pizzaElectricityConsumption);
    System.out.println("pizzaSignatureBurn : " + pizzaSignatureBurn);
  }
}
//==============================================================================
// headOfficeName = 옛 추억 붕어빵 본사
// beanShopName : 30년 전통 팥 붕어빵 가게
// beanTaste : 팥빵
// beanRoastTime : 5
// beanFirePower : 8
// beanElectricityConsumption : 40
// beanSignatureBurn : 시그니처 붕어빵
// pizzaShopName : 옛 추억 피자 붕어빵 가게
// pizzaTaste : 피자
// pizzaRoastTime : 7
// pizzaFirePower : 5
// pizzaElectricityConsumption : 35
// pizzaSignatureBurn : 시그니처 붕어빵
```

<br/><br/><br/>

### 최종 코드

---

```java
public interface SignatureMachineDesign{

    abstract String signatureBurn();
}
//==============================================================================
public interface FishBurnMachineDesign extends SignatureMachineDesign {

  int ROAST_TIME_SET = 3;

  // static final 생략 가능
  static final String FISH_BURN_MACHINE_NAME = "붕어빵 기계";



  String taste();     // 맛
  int roastTime();    // 굽기 시간 조절

  // abstract 생략 가능
  abstract int firePower();    // 불의 강도
  abstract int electricityConsumption(); // 전기 소모량

  // 가게 간판 만들기
  default String shopName(String name) {
    String firstName = shopFirstName();
    if (name != null && name.trim().length() != 0) {
      return firstName + name + " 붕어빵 가게";
    } else {
      return firstName + "신규 붕어빵 가게";
    }
  }

  static String headOfficeName() {
    String firstName = headOfficeFirstName();
    return firstName + "붕어빵 본사";
  }

  private String shopFirstName() {
    return "옛 추억 ";
  }

  private static String headOfficeFirstName() {
    return "옛 추억 ";
  }
}
//==============================================================================
public class BeanFishBurnShop implements FishBurnMachineDesign {

  @Override
  public String taste() {
    return "팥빵";
  }

  @Override
  public int roastTime() {
    return 5; // 굽는 시간
  }

  @Override
  public int firePower() {
    return 8; // 1부터 10까지라면
  }

  @Override
  public int electricityConsumption() {
    return 40; // 5분동안 불의 강도 8로 붕어빵 굽는 기준
  }

  @Override
  public String signatureBurn() {
    return "시그니처 붕어빵";
  }

  @Override
  public String shopName(String name) {
    if (name != null && name.trim().length() != 0) {
      return "30년 전통 " + name + " 붕어빵 가게";
    } else {
      return "신규 붕어빵 가게";
    }
  }
}
//==============================================================================
public class PizzaFishBurnShop implements FishBurnMachineDesign {

  @Override
  public String taste() {
    return "피자";
  }

  @Override
  public int roastTime() {
    return 7; // 굽는 시간
  }

  @Override
  public int firePower() {
    return 5; // 1부터 10까지라면
  }

  @Override
  public int electricityConsumption() {
    return 35; // 7분동안 불의 강도 5로 붕어빵 굽는 기준
  }

  @Override
  public String signatureBurn() {
    return "시그니처 붕어빵";
  }
}
//==============================================================================
public class FishBurnShop {

  public static void main(String[] args) {

    String headOfficeName = FishBurnMachineDesign.headOfficeName();
    System.out.println("headOfficeName = " + headOfficeName);

    BeanFishBurnShop beanShop = new BeanFishBurnShop();
    String beanTaste  = beanShop.taste();
    int beanRoastTime = beanShop.roastTime();
    int beanFirePower = beanShop.firePower();
    int beanElectricityConsumption = beanShop.electricityConsumption();
    String beanSignatureBurn = beanShop.signatureBurn();
    String beanShopName = beanShop.shopName("팥");

    System.out.println("beanShopName : " + beanShopName);
    System.out.println("beanTaste : " + beanTaste);
    System.out.println("beanRoastTime : " + beanRoastTime);
    System.out.println("beanFirePower : " + beanFirePower);
    System.out.println("beanElectricityConsumption : " + beanElectricityConsumption);
    System.out.println("beanSignatureBurn : " + beanSignatureBurn);

    PizzaFishBurnShop pizzaShop = new PizzaFishBurnShop();
    String pizzaTaste  = pizzaShop.taste();
    int pizzaRoastTime = pizzaShop.roastTime();
    int pizzaFirePower = pizzaShop.firePower();
    int pizzaElectricityConsumption = pizzaShop.electricityConsumption();
    String pizzaSignatureBurn = pizzaShop.signatureBurn();
    String pizzaShopName = pizzaShop.shopName("피자");

    System.out.println("pizzaShopName : " + pizzaShopName);
    System.out.println("pizzaTaste : " + pizzaTaste);
    System.out.println("pizzaRoastTime : " + pizzaRoastTime);
    System.out.println("pizzaFirePower : " + pizzaFirePower);
    System.out.println("pizzaElectricityConsumption : " + pizzaElectricityConsumption);
    System.out.println("pizzaSignatureBurn : " + pizzaSignatureBurn);
  }
}
```