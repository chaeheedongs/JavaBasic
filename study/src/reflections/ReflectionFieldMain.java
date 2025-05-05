package reflections;

import java.lang.reflect.Field;

public class ReflectionFieldMain {

    public static void main(String[] args) {
        User user = new User("honggildong", 20);
        Class<? extends User> userClazz = user.getClass();

        try {
            /* case1 :: name이라는 이름을 가진 필드만 가져오기 */
            Field nameField = userClazz.getDeclaredField("name");
        } catch (NoSuchFieldException e) {
            // .. do nothing
        }

        /* case2 :: 해당 클래스의 필드 모두 가져오기 */
        Field[] fields = userClazz.getDeclaredFields();
        for (Field field : fields) {
            try {
                /* field에 접근 가능하도록 설정 */
                field.setAccessible(true);

                /* 필드명과 값을 가져오는 방법 */
                System.out.println("field = " + field);
                System.out.println("field name = " + field.getName());
                System.out.println("field value = " + field.get(user));
                System.out.println();
            } catch (IllegalAccessException e) {
                // .. do nothing
            }
        }
    }
}
