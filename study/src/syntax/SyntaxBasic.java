package syntax;

public class SyntaxBasic {

    public static void main(String[] args) {

        /**
         * 조건문
         */

        boolean condition = true;

        if (condition) {
            // 조건이 참 일때 수행되는 로직
            System.out.println("condition is true");
        }


        boolean trueCondition = true;
        boolean falseCondition = false;

        //if( trueCondition ) {
        if (falseCondition) {
            // 조건이 참 일 때 수행되는 로직
            System.out.println("condition is true");
        } else {
            // 조건이 거짓 일 때 수행되는 로직
            System.out.println("condition is false");
        }


        int intValue = 10;

        if (intValue == 0) {
            System.out.println("intValue의 값은 0 입니다.");
        } else if (intValue > 10) {
            System.out.println("intValue의 값은 10 보다 큽니다.");
        } else if (intValue == 10) {
            System.out.println("intValue의 값은 10 입니다.");
        } else {
            System.out.println("모든 조건이 맞지 않을 경우 수행되는 로직입니다.");
        }


        String fooStr = "foo";
        String barStr = "bar";
        String bazStr = "baz";
        String etcStr = "etc";

        switch (barStr) {
//      switch(bazStr) {
//      switch(etcStr) {
//        switch(fooStr) {
            case "foo":
                System.out.println("Hello foo");
                break;
            case "bar":
                System.out.println("Hello bar");
            case "baz":
                System.out.println("Hello baz");
                break;
            default:
        }


        /**
         * 반복문
         */

        int dan = 2;

        for (int i = 1; i < 10; i++) {
            int result = dan * i;
            System.out.println(dan + " * " + i + " = " + result);
        }

        String[] studentNames = {"foo", "bar", "baz"};

        for (String name : studentNames) {
            name = name + " !";
            System.out.println("student name is " + name);
        }

        System.out.println(studentNames[0]);
        System.out.println(studentNames[1]);
        System.out.println(studentNames[2]);



        dan = 3;
        int increaseValue = 1;

        while (increaseValue < 10) {

            int result = dan * increaseValue;

            System.out.println(dan + " * " + increaseValue + " = " + result);

            increaseValue = increaseValue + 1;

        }



        dan = 4;
        increaseValue = 1;

        do {

            int result = dan * increaseValue;

            System.out.println(dan + " * " + increaseValue + " = " + result);

            increaseValue = increaseValue + 1;

        } while (increaseValue < 10);

    }
}
