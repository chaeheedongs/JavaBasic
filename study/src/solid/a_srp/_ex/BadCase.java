package solid.a_srp._ex;

public class BadCase {

    static class Animal {
        String type;

        public Animal(String type) {
            this.type = type;
        }
    }

    static class HelloAnimal {
        public void hello(Animal animal) {
            if ("Cat".equals(animal.type)) {
                System.out.println("냐옹");
            } else if ("Dog".equals(animal.type)) {
                System.out.println("멍멍");
            }
            /* 2. 변경되는 부분도 추가적으로 수정해주어야 한다. */
            else if ("Sheep".equals(animal.type)) {
                System.out.println("메에에");
            }
            else if ("Lion".equals(animal.type)) {
                System.out.println("어흥");
            }
        }
    }

    public static void main(String[] args) {
        HelloAnimal helloAnimal = new HelloAnimal();

        /* 기존 로직 */
        final Animal cat = new Animal("Cat");
        final Animal dog = new Animal("Dog");

        helloAnimal.hello(cat);
        helloAnimal.hello(dog);

        /* 1. 확장한다면? */
        final Animal sheep = new Animal("Sheep");
        final Animal Lion = new Animal("Lion");

        /* 3. 변경이 열려있고, 확장이 닫혀있다. */
        helloAnimal.hello(sheep);
        helloAnimal.hello(Lion);
    }
}
