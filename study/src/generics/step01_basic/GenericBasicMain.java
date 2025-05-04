package generics.step01_basic;

import generics.step01_basic.vo.Fruit;

public class GenericBasicMain {

    public static void main(String[] args) {

        /**
         * Generic은 컴파일(.java -> .class) 시점에 타입소거가 이루어진다.
         *
         * 타입소거(Type Erasure) / (Reifiable/non-Raifiable):
         * -> 컴파일 시점에 비실체화 타입(제네릭)을 찾아 실체화 타입으로 변환해 준다.
         *    이 과정에서 제네릭 타입이 모두 제거된다.
         * */

        Fruit<String> apple = new Fruit<>("apple");
        System.out.println("apple = " + apple);

        Fruit<String> banana = new Fruit<>("banana");
        System.out.println("banana = " + banana);
    }
}
