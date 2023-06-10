# Enum

## 목차

---

- enum 소개
- enum 정의하는 방법
- enum이 제공하는 메소드
- java.lang.Enum
- EnumSet

---

<br/><br/><br/>

### enum 소개

---

- enum은 열거형 타입이다.
- 필드가 모두 상수(static final) 이다.
- 프로그램 로드시 클래스로더가 JVM Method 영역에 로드 한다.
- 서로 관련된 상수를 모아서 관리한다.
  - 유지보수가 용이하다.
  - 개발자에게 정확한 의사를 코드로 표현할 수 있다.
- 상수이므로 관례적으로 모두 대문자와 밑줄로 표기한다.
- 생성자의 접근 제한자는 무조건 private 이다.

<br/><br/><br/>

### enum 정의하는 방법

---

```java
// 값이 없는 경우
enum Rgb {
    RED,
    GREEN,
    BLUE
}
// =============================================================================
// 값이 있는 경우
enum Day {
    SUNDAY("일요일", true),
    MONDAY("월요일", false),
    TUESDAY("화요일", false),
    WEDNESDAY("수요일", false),
    THURSDAY("목요일", false),
    FRIDAY("금요일", false),
    SATURDAY("토요일", true);

    private String day;
    private boolean isWeekend;

    /**
     * Enum은 외부에서 생성 불가능 !
     */
    private Day(String day, boolean isWeekend) {
        this.day = day;
        this.isWeekend = isWeekend;
    }

    public String getKoreaDay() {
        return day;
    }

    public boolean isWeekend() {
        return isWeekend;
    }
}
// =============================================================================
public class EnumDay {

    public static void main(String[] args) {

        
        // 기본 호출
        System.out.println(Rgb.RED);
        System.out.println(Rgb.GREEN);
        System.out.println(Rgb.BLUE);
        System.out.println();
        

        // 기본 호출
        System.out.println(Day.SUNDAY);
        System.out.println(Day.MONDAY);
        System.out.println(Day.TUESDAY);
        System.out.println(Day.WEDNESDAY);
        System.out.println(Day.THURSDAY);
        System.out.println(Day.FRIDAY);
        System.out.println(Day.SATURDAY);
        System.out.println();


        // 한국 요일
        System.out.println(Day.SUNDAY.getKoreaDay());
        System.out.println(Day.MONDAY.getKoreaDay());
        System.out.println(Day.TUESDAY.getKoreaDay());
        System.out.println(Day.WEDNESDAY.getKoreaDay());
        System.out.println(Day.THURSDAY.getKoreaDay());
        System.out.println(Day.FRIDAY.getKoreaDay());
        System.out.println(Day.SATURDAY.getKoreaDay());
        System.out.println();


        // 주말 확인
        System.out.println("   SUNDAY is weekend? : " + Day.SUNDAY.isWeekend());
        System.out.println("   MONDAY is weekend? : " + Day.MONDAY.isWeekend());
        System.out.println("  TUESDAY is weekend? : " + Day.TUESDAY.isWeekend());
        System.out.println("WEDNESDAY is weekend? : " + Day.WEDNESDAY.isWeekend());
        System.out.println(" THURSDAY is weekend? : " + Day.THURSDAY.isWeekend());
        System.out.println("   FRIDAY is weekend? : " + Day.FRIDAY.isWeekend());
        System.out.println(" SATURDAY is weekend? : " + Day.SATURDAY.isWeekend());
        System.out.println();
    }
}
// =============================================================================
// RED
// GREEN
// BLUE
// 
// SUNDAY
// MONDAY
// TUESDAY
// WEDNESDAY
// THURSDAY
// FRIDAY
// SATURDAY
// 
// 일요일
// 월요일
// 화요일
// 수요일
// 목요일
// 금요일
// 토요일
// 
//    SUNDAY is weekend? : true
//    MONDAY is weekend? : false
//   TUESDAY is weekend? : false
// WEDNESDAY is weekend? : false
//  THURSDAY is weekend? : false
//    FRIDAY is weekend? : false
//  SATURDAY is weekend? : true
```

<br/><br/><br/>

### enum이 제공하는 메소드

---

- RGB 열거 클래스를 기준으로 테스트 한다.

|                          메서드                        | 설명                                           |
|:------------------------------------------------------:|:-----------------------------------------------|
|                        values()                        | 열거 클래스의 값을 전부 조회                   |
|                 valueOf(String string)                 | 매개변수의 문자열과 일치하는 열거 상수 호출    |
|  valueOf(@NotNull Class<RGB>, @NotNull String string)  | 클래스와 문자열이 일치하는 열거 상수 호출      |
|                       ordinal()                        | 열거 상수의 순서를 int형으로 반환              |
|             equals(@Nullable Object other)             | enum 비교                                      |
|                       hashCode()                       | 해쉬코드 조회                                  |


```java
enum Rgb {
    RED,
    GREEN,
    BLUE;
}

public class EnumTest {

    public static void main(String[] args) {

        // 기본 호출 방식
        System.out.println(Rgb.RED);
        System.out.println(Rgb.GREEN);
        System.out.println(Rgb.BLUE);
        System.out.println();


        // 전체 호출 방식
        //  - values()
        Rgb[] rgbs = Rgb.values();
        for (int i = 0; i < rgbs.length; i++) {
            System.out.println("rgbs[" + i + "] : " + rgbs[i]);
        }
        System.out.println();


        // 문자열과 일치하는 열거체 상수 호출
        //  - valueOf(String string)
        Rgb red = Rgb.valueOf("RED");
        System.out.println("value = " + red);
        System.out.println();


        // 클래스와 문자열이 일치하는 열거체 상수 호출
        //  - valueOf(@NotNull Class<RGB>, @NotNull String string)
        Rgb blue = Rgb.valueOf(Rgb.class, "BLUE");
        System.out.println("value = " + blue);
        System.out.println();


        // 열거체가 정의된 순서를 반환
        // - ordinal()
        int ordinalRed   = Rgb.RED.ordinal();
        int ordinalGreen = Rgb.GREEN.ordinal();
        int ordinalBlue  = Rgb.BLUE.ordinal();
        System.out.println("ordinalRed   = " + ordinalRed);
        System.out.println("ordinalGreen = " + ordinalGreen);
        System.out.println("ordinalBlue  = " + ordinalBlue);
        System.out.println();


        // enum 비교
        // - equals(@Nullable Object other)
        boolean isEqual    = Rgb.RED.equals(Rgb.RED);
        boolean isNotEqual = Rgb.RED.equals(Rgb.BLUE);
        System.out.println("RGB.RED.equals(RGB.RED) result  = " + isEqual);
        System.out.println("RGB.RED.equals(RGB.BLUE) result = " + isNotEqual);
        System.out.println();


        // 해쉬코드 조회
        // - hashCode()
        int redHash   = Rgb.RED.hashCode();
        int greenHash = Rgb.GREEN.hashCode();
        int blueHash  = Rgb.BLUE.hashCode();
        System.out.println("redHash   = " + redHash);
        System.out.println("greenHash = " + greenHash);
        System.out.println("blueHash  = " + blueHash);
        System.out.println();


        // switch for syntax
        Rgb redSwitch   = Rgb.valueOf("RED");
        Rgb greenSwitch = Rgb.valueOf("GREEN");
        Rgb blueSwitch  = Rgb.valueOf("BLUE");
        enumSwitchSyntax(Rgb.valueOf("RED"));
        enumSwitchSyntax(Rgb.valueOf("GREEN"));
        enumSwitchSyntax(Rgb.valueOf("BLUE"));
    }

    public static void enumSwitchSyntax(Rgb rgb) {
        switch (rgb) {
            case RED:
                System.out.println("switch red");
                break;
            case GREEN:
                System.out.println("switch green");
                break;
            case BLUE:
                System.out.println("switch blue");
                break;
            default:
                System.out.println("default");
        }
    }
}
// =============================================================================
// RED
// GREEN
// BLUE
// 
// rgbs[0] : RED
// rgbs[1] : GREEN
// rgbs[2] : BLUE
// 
// value = RED
// 
// value = BLUE
// 
// ordinalRed   = 0
// ordinalGreen = 1
// ordinalBlue  = 2
// 
// RGB.RED.equals(RGB.RED) result  = true
// RGB.RED.equals(RGB.BLUE) result = false
// 
// redHash   = 998351292
// greenHash = 1684106402
// blueHash  = 335471116
//
// switch red
// switch green
// switch blue
```

<br/><br/><br/>

### java.lang.Enum

---

- API 확인

```java
package java.lang;

import java.io.Serializable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;

/**
 * 모든 Java 언어 열거 유형의 공통 기본 클래스입니다.
 *
 * 메소드의 설명을 포함한 열거형에 대한
 * 더 많은 정보는 자바 언어 규격의 섹션 8.9에서 찾을 수 있다.
 *
 * 열거 유형을 세트의 유형 또는 맵의 키 유형으로 사용할 경우 
 * 전문적이고 효율적인 {@linkplain java.util.EnumSet set}이(가) 필요합니다.
 * {@linkplain java.util.EnumMap map} 구현을 사용할 수 있습니다.
 *
 * @param <E> The enum type subclass
 * @author  Josh Bloch
 * @author  Neal Gafter
 * @see     Class#getEnumConstants()
 * @see     java.util.EnumSet
 * @see     java.util.EnumMap
 * @since   1.5
 */
@SuppressWarnings("serial") // No serialVersionUID needed due to
// 열거 형 유형의 특수 케이스
public abstract class Enum<E extends Enum<E>>
        implements Comparable<E>, Serializable {
    /**
     * 열거형 선언에서 선언된 이 열거형 상수의 이름입니다.
     * 대부분의 프로그래머는 이 필드에 액세스하는 대신 
     * {@link #toString} 메서드를 사용해야 합니다.
     */
    private final String name;

    /**
     * 열거형 선언에 선언된 대로 이 열거형 상수의 이름을 반환합니다.
     *
     * toString 메서드는 사용자에게 친숙한 이름을 반환할 수 있으므로
     * 대부분의 프로그래머는 이 메서드보다
     * {@link #toString} 메서드를 사용해야 합니다.
     * 
     * 이 방법은 정확한 이름을 얻는 데 따라 정확도가 달라지는 
     * 특수 상황에서 주로 사용하도록 설계되었으며, 
     * 릴리스마다 다르지 않습니다.
     *
     * @return 이 열거형 상수의 이름
     */
    public final String name() {
        return name;
    }

    /**
     * 이 열거 상수의 순서형
     * ( 열거형 선언에서 해당 위치, 초기 상수에 0의 순서가 할당됨)
     * 입니다.
     *
     * 대부분의 프로그래머들은 이 분야에 쓸모가 없을 것이다.
     * {@link java.util.EnumSet} 과 {@link java.util.EnumMap}
     * 같은 고급 열거형 기반 데이터 구조에서 사용하도록 설계되었습니다.
     */
    private final int ordinal;

    /**
     * 이 열거 상수의 순서형
     * (이 열거형 선언에서 해당 위치, 초기 상수에 0의 순서가 할당됨)을 
     * 반환합니다.
     *
     * 대부분의 프로그래머들은 이 방법을 쓸모가 없을 것이다.
     * {@link java.util.EnumSet} 과 {@link java.util.EnumMap}
     * 같은 고급 열거형 기반 데이터 구조에서 사용하도록 설계되었습니다.
     *
     * @return 이 열거 상수의 서수
     */
    public final int ordinal() {
        return ordinal;
    }

    /**
     * 단독 생성자.
     * 프로그래머는 이 생성자를 호출할 수 없습니다.
     * 컴파일러가 열거형 선언에 응답하여 내보낸 코드에서 사용하기 위한 것이다.
     *
     * @param name - 이 열거 상수의 이름.
     *               이 열거 상수를 선언하는 데 사용되는 식별자입니다.
     * @param ordinal - 이 열거 상수의 순서형( 열거형 선언에서 해당 위치, 초기 상수에 0의 순서가 할당됨)입니다.
     */
    protected Enum(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
    }

    /**
     * 선언에 포함된 이 열거 상수의 이름을 반환합니다.
     * 이 메서드는 일반적으로 필요하거나 바람직하지 않지만 재정의될 수 있습니다.
     * 더 "프로그래머 친화적인" 문자열 양식이 존재할 경우
     * 열거형은 이 메서드를 재정의해야 합니다.
     *
     * @return 이 열거 상수의 이름
     */
    public String toString() {
        return name;
    }

    /**
     * 지정한 개체가 이 열거 상수와 같으면 true를 반환합니다.
     *
     * @param other 이 개체와 동일성을 위해 비교할 개체입니다.
     * @return  지정한 개체가 이 열거 상수와 같으면 true입니다.
     */
    public final boolean equals(Object other) {
        return this==other;
    }

    /**
     * 이 열거형 상수에 대한 해시 코드를 반환합니다.
     *
     * @return 이 열거형 상수에 대한 해시 코드입니다.
     */
    public final int hashCode() {
        return super.hashCode();
    }

    /**
     * 지원되지 않는 복제예외를 던집니다.
     * 이것은 Enum이 복제되지 않는다는 것을 보장하며,
     * 이것은 그들의 "싱글톤" 상태를 보존하는 데 필요하다.
     *
     * @return (never returns)
     */
    protected final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    /**
     * 이 열거형을 지정된 주문 개체와 비교합니다.
     * 이 개체가 지정된 개체보다 작거나 같거나 크므로 
     * 음의 정수, 0 또는 양의 정수를 반환합니다.
     *
     * 열거형 상수는 동일한 열거형 유형의 다른 열거형 상수와만 비교할 수 있습니다.
     * 이 방법에 의해 구현되는 자연 순서는 상수가 선언되는 순서입니다.
     */
    public final int compareTo(E o) {
        Enum<?> other = (Enum<?>)o;
        Enum<E> self = this;
        if (self.getClass() != other.getClass() && // optimization
                self.getDeclaringClass() != other.getDeclaringClass())
            throw new ClassCastException();
        return self.ordinal - other.ordinal;
    }

    /**
     * 이 열거형 상수의 열거형 유형에 해당하는 Class 개체를 반환합니다.
     * 두 열거형 상수 e1과 e2는
     * e1.getDeclaringClass() == e2.getDeclaringClass()인 경우에만
     * 동일한 열거형 형식입니다.
     * 이 메서드에서 반환되는 값은 상수 특정 클래스 본체가 있는 열거형 상수에 대해
     * {@linkObject#getClass} 메서드에서 반환되는 값과 다를 수 있습니다.
     *
     * @return 이 열거형 상수의 열거형 유형에 해당하는 Class 개체
     */
    @SuppressWarnings("unchecked")
    public final Class<E> getDeclaringClass() {
        Class<?> clazz = getClass();
        Class<?> zuper = clazz.getSuperclass();
        return (zuper == Enum.class) ? (Class<E>)clazz : (Class<E>)zuper;
    }

    /**
     * 지정한 이름의 지정한 열거형 형식의 열거형 상수를 반환합니다.
     * 이름은 이 형식의 열거형 상수를 선언하는 데 
     * 사용되는 식별자와 정확히 일치해야 합니다. 
     * (외부 공백 문자는 허용되지 않습니다.)
     *
     * 특정 열거형 유형 {@code T}에 대해 해당 열거형에 대해 
     * 암시적으로 선언된 {@code public static TvalueOf(String)} 메서드를 
     * 이 메서드 대신 사용하여 이름에서 해당 열거형 상수로 매핑할 수 있습니다.
     * 열거형 유형의 모든 상수는
     * 해당 유형의 암시적 {@code public static T[] values()} 메서드를 호출하여 
     * 얻을 수 있습니다.
     *
     * @param <T> 상수를 반환할 열거형
     * @param enumType 상수를 반환할 열거형 유형의 {@codeClass} 개체
     * @param name 반환할 상수의 이름
     * @return 지정한 이름의 지정된 열거형 유형의 열거형 상수
     * @throws IllegalArgumentException if the specified enum type has
     *         no constant with the specified name, or the specified
     *         class object does not represent an enum type
     * @throws NullPointerException if {@code enumType} or {@code name}
     *         is null
     * @since 1.5
     */
    public static <T extends Enum<T>> T valueOf(Class<T> enumType,
                                                String name) {
        T result = enumType.enumConstantDirectory().get(name);
        if (result != null)
            return result;
        if (name == null)
            throw new NullPointerException("Name is null");
        throw new IllegalArgumentException(
                "No enum constant " + enumType.getCanonicalName() + "." + name);
    }

    /**
     * 열거형 클래스에는 finalize 메서드를 사용할 수 없습니다.
     */
    @SuppressWarnings("deprecation")
    protected final void finalize() { }

    /**
     * 디폴트 역직렬화 방지
     */
    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        throw new InvalidObjectException("can't deserialize enum");
    }

    private void readObjectNoData() throws ObjectStreamException {
        throw new InvalidObjectException("can't deserialize enum");
    }
}
```

<br/><br/><br/>

### EnumSet

---

- Enum과 Collection의 Set이 구현된 추상 클래스 이다.
- 산술 비트 연산을 사용하므로 연산이 매우 빠르다.
  - 계산시 하나의 비트만 필요로 해서 더 빠름
- 백터의 특성으로 인해 메모리를 적게 사용 한다.

```java
enum Color {
  RED, YELLOW, GREEN, BLUE, BLACK, WHITE
}

public class EnumSets {

  public static void main(String[] args) {

    /**
     * public abstract class EnumSet<E extends Enum<E>> 
     *     extends AbstractSet<E>
     *     implements Cloneable, java.io.Serializable
     */
    EnumSet<Color> set = EnumSet.allOf(Color.class);
    set.forEach(System.out::println);
    System.out.println();

    EnumSet<Color> set2 = EnumSet.noneOf(Color.class);
    set2.forEach(System.out::println);
    System.out.println();

    EnumSet<Color> set3 = EnumSet.of(BLUE, YELLOW);
    set3.forEach(System.out::println);
    System.out.println();


    EnumSet<Color> set4 = EnumSet.complementOf(set3);
    set4.forEach(System.out::println);
    System.out.println();

    EnumSet<Color> set5 = EnumSet.copyOf(set4);
    set5.forEach(System.out::println);
    System.out.println();

    set5.add(BLUE);
    set5.forEach(System.out::println);
    System.out.println();

    boolean set6 = set5.contains(RED);
    System.out.println(set6);
    System.out.println();

    set5.remove(RED);
    set5.forEach(System.out::println);
    System.out.println();
  }
}
// =============================================================================
// RED
// YELLOW
// GREEN
// BLUE
// BLACK
// WHITE
// 
// 
// YELLOW
// BLUE
// 
// RED
// GREEN
// BLACK
// WHITE
// 
// RED
// GREEN
// BLACK
// WHITE
// 
// RED
// GREEN
// BLUE
// BLACK
// WHITE
// 
// true
// 
// GREEN
// BLUE
// BLACK
// WHITE
```

<br/><br/><br/>