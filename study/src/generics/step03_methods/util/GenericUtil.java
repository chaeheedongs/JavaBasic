package generics.step03_methods.util;

public class GenericUtil {

    /* 제네릭 메서드는 타입 파라미터를 가지고 있다.
    * 주로 유틸 클래스 내에서 사용되며,
    * 클래스의 제네릭과 상관없이 독립적이다.
    * -----------------------------------------------
    * 제네릭 메서드
    * - 인스턴스 제네릭 메서드
    *   public <T> void method(T t)
    *
    * - 스테틱 제네릭 메서드 (사용처를 아직 모르겠다.)
    *   static <T> void method(T t)
    *
    * - 퍼블릭 스테틱 제네릭 메서드 (유틸용 메서드로 사용됨)
    *   public static <T> void methd(T t) */
    public static <T> String convertStringBy(T string) {
        if (string == null) {
            return "";
        }

        if (string instanceof String) {
            return (String) string;
        }

        return string.toString();
    }
}
