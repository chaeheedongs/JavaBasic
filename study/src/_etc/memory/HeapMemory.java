package _etc.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class HeapMemory {

    public static void main(String[] args) {

        /**
         * Heap Memory
         * --------------------
         * -> Thread n : 1 Heap
         * -> 쓰레드가 여러개여도(Stack n) 하나의 힙만 생성 된다.
         * -> Heap은 Reference들의 값과 주소를 가지고 있다.
         * -> Stack에서 Reference Type에 대한 주소 값을 Heap에서 참조 한다.
         */

        // Immutable
        String strValue = "hello world";
        String strValueTwo = "hello world";
        String strIsImmutable = new String("String is Immutable");

        /**
         *       strValue : 1794106052
         *    strValueTwo : 1794106052
         * strIsImmutable : -400615045
         */
        System.out.println("      strValue : " + strValue.hashCode());
        System.out.println("   strValueTwo : " + strValueTwo.hashCode());
        System.out.println("strIsImmutable : " + strIsImmutable.hashCode());
        System.out.println();
        System.out.println("      strValue : " + System.identityHashCode(strValue));
        System.out.println("   strValueTwo : " + System.identityHashCode(strValueTwo));
        System.out.println("strIsImmutable : " + System.identityHashCode(strIsImmutable));


        ArrayList list = new ArrayList<>();
        HashSet set = new HashSet();
        HashMap map = new HashMap();
    }
}
