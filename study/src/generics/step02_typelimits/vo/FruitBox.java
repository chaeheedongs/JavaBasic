package generics.step02_typelimits.vo;

import java.util.ArrayList;
import java.util.List;

public class FruitBox<T extends Fruit> {
    private List<T> fruits = new ArrayList<>();

    public FruitBox() { }

    public T addOne(T fruit) {
        this.fruits.add(fruit);
        return fruit;
    }

    public List<T> addAll(List<T> fruitList) {
        this.fruits.addAll(fruitList);
        return fruitList;
    }

    public T[] addAll(T... fruitArray) {
        for (T fruit : fruitArray) {
            this.fruits.add(fruit);
        }
        return fruitArray;
    }

    public List<T> findAll() {
        return this.fruits;
    }

    @Override
    public String toString() {
        return "FruitBox{" +
                "fruits=" + fruits +
                '}';
    }
}
