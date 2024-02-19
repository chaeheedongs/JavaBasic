package _etc.memory;

public class StackMemory {

    public static void main(String[] args) {

        /**
         * Stack Memory
         * --------------------
         * -> Thread 1 : 1 Stack
         * -> 1 쓰레드당 1 스텍을 할당 받는다.
         * -> Stack은 Primitive 데이터들과 Heap의 주소를 참조하는 Reference 변수를 들고 있다.
         */

        // primitive types
        char charValue = 'c';
        byte byteValue = 0;
        short shortValue = 1;
        int intValue = 2;
        long longValue = 3;
        float floatValue = 4.4f;
        double doubleValue = 5.5d;
        boolean boolValue = true;
    }
}
