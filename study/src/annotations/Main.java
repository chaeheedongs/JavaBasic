package annotations;

public class Main {

    public static void main(String[] args) {

        @Fruit("apple")
        @Fruit("banana")
        String fruitName;

        User user = new User();
        System.out.println(user.toString());
    }
}
