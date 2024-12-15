package solid.a_srp._ex;

public class GoodCase {

    interface Animal {
        void speak();
    }

    static class Cat implements Animal {
        @Override
        public void speak() {
            System.out.println("냐옹");
        }
    }

    static class Dog implements Animal {
        @Override
        public void speak() {
            System.out.println("멍멍");
        }
    }

    /* 2. 기존 로직을 수정하지 않고 새로 만든다. */
    static class Lion implements Animal {
        @Override
        public void speak() {
            System.out.println("어흥");
        }
    }

    static class HelloAnimal {
        private final Animal animal;

        public HelloAnimal(final Animal animal) {
            this.animal = animal;
        }

        public void hello() {
            this.animal.speak();
        }
    }

    public static void main(String[] args) {
        /* 기존 로직 */
        final Animal cat = new Cat();
        final HelloAnimal catAnimal = new HelloAnimal(cat);
        catAnimal.hello();

        final Animal dog = new Dog();
        final HelloAnimal dogAnimal = new HelloAnimal(dog);
        dogAnimal.hello();

        /* 1. 확장한다면? */
        final Animal lion = new Lion();
        final HelloAnimal lionAnimal = new HelloAnimal(lion);

        /* 3. 변경은 닫혀있고, 확장엔 열려있다. */
        lionAnimal.hello();
    }
}
