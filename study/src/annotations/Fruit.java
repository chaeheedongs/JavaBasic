package annotations;

import java.lang.annotation.Repeatable;

@Repeatable(Fruits.class)
public @interface Fruit {
    String value();
}
