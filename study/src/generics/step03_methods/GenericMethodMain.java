package generics.step03_methods;

import generics.step03_methods.util.GenericUtil;

public class GenericMethodMain {

    public static void main(String[] args) {

        String floatToStringValue = GenericUtil.convertStringBy(1234.5678);
        System.out.println("floatToStringValue = " + floatToStringValue);
        System.out.println("floatToStringValue.getClass().getSimpleName() = " + floatToStringValue.getClass().getSimpleName());
        System.out.println();

        String intToStringValue = GenericUtil.convertStringBy(12345);
        System.out.println("intToStringValue = " + intToStringValue);
        System.out.println("intToStringValue.getClass().getSimpleName() = " + intToStringValue.getClass().getSimpleName());
    }
}
