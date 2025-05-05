package reflections;

public class ReflectionMain {

    public static void main(String[] args) {
        /* reflection 조회 방식 1 */
        Class<User> userClazz = User.class;

        /* reflection 조회 방식 2 */
        User gildong = new User("honggildong", 20);
        Class<? extends User> gildongClazz = gildong.getClass();

        try {
            /* reflection 조회 방식 3 */
            Class<?> findClazzFromPath = Class.forName("path");
        } catch (ClassNotFoundException e) {
            // .. do nothing
        }
    }
}
