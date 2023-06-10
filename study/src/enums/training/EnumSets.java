package enums.training;

import java.util.EnumSet;

import static enums.training.Color.*;

enum Color {
    RED, YELLOW, GREEN, BLUE, BLACK, WHITE
}

public class EnumSets {

    public static void main(String[] args) {

        /**
         * EnumSet의 모든 메서드는 산술 비트 연산을 사용하여 구현되므로
         * 일반적인 연산이 매우 빠르게 계산된다.
         *
         * EnumSet은 HashSet 같은 다른 Set 구현체와 비교했을 때,
         * 데이터가 예상 가능한 순서로 저장되어 있고,
         * 각 계산을 하는데 하나의 비트만이 필요하므로 더 빠르다고 할 수 있다.
         * 또한 HashSet 처럼 데이터를 저장할 버킷을 찾는 데 hashcode를 계산할 필요가 없다.
         *
         * 더욱이 EnumSet은 비트 벡터의 특성상 더 작은 메모리를 사용한다.
         */

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