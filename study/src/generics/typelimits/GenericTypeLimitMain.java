package generics.typelimits;

import generics.typelimits.vo.*;

import java.util.List;

public class GenericTypeLimitMain {

    public static void main(String[] args) {

        Apple apple = new Apple();
        Banana banana = new Banana();
        Cherry cherry = new Cherry();

        FruitBox<Fruit> fruitBoxCase1 = new FruitBox<>();
        fruitBoxCase1.addOne(apple);
        fruitBoxCase1.addOne(banana);
//        fruitBoxCase1.addOne(cherry); // 컴파일 에러 (Cherry cannot be converted to Fruit)
        System.out.println("fruitBoxCase1 = " + fruitBoxCase1);

        FruitBox<Fruit> fruitBoxCase2 = new FruitBox<>();
        fruitBoxCase2.addAll(List.of(apple, banana));
        System.out.println("fruitBoxCase2 = " + fruitBoxCase2);

        FruitBox<Fruit> fruitBoxCase3 = new FruitBox<>();
        fruitBoxCase3.addAll(apple, banana);
        System.out.println("fruitBoxCase3 = " + fruitBoxCase3);
    }
}
