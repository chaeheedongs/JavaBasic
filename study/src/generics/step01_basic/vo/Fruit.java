package generics.step01_basic.vo;

public class Fruit<T> {

    private T name;

    public Fruit(T name) {
        this.name = name;
    }

    public T getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name=" + name +
                '}';
    }
}
