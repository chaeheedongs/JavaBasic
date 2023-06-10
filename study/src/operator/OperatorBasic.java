package operator;

public class OperatorBasic {

    public static void main(String[] args) {

        // 산술 연산자
        // +, -, *, /, %
        int plus      = 1 + 1;
        int minus     = 1 - 1;
        int multiply  = 1 * 1;
        int divide    = 1 / 1;
        int remainder = 1 % 1;
        System.out.println("1 + 1 = " + plus);
        System.out.println("1 - 1 = " + minus);
        System.out.println("1 * 1 = " + multiply);
        System.out.println("1 / 1 = " + divide);
        System.out.println("1 % 1 = " + remainder);

        // =============================================

        // 비트 연산자
        // <<, >>, >>>, &, |, ^, ~,

        // =============================================

        // 관계 연산자
        // >, >=, <, <=, ==, !=
        int big   = 10;
        int small = 1;
        System.out.println("big > small = " + (big > small));
        System.out.println("big >= small = " + (big >= small));
        System.out.println("big < small = " + (big < small));
        System.out.println("big <= small = " + (big <= small));
        System.out.println("big == small = " + (big == small));
        System.out.println("big != small = " + (big != small));

        // =============================================

        // 논리 연산자
        // &&, ||, !

        // AND 연산
        System.out.println("true && true = "   + (true && true));
        System.out.println("true && false = "  + (true && false));
        System.out.println("false && true = "  + (false && true));
        System.out.println("false && false = " + (false && false));

        // OR 연산
        System.out.println("true || true = "   + (true || true));
        System.out.println("true || false = "  + (true || false));
        System.out.println("false || true = "  + (false || true));
        System.out.println("false || false = " + (false || false));

        // NOT 연산
        System.out.println("!true = "  + !true);
        System.out.println("!false = " + !false);

        // =============================================

        // instanceof
        String stringType = "Hello World!";
        System.out.println("stringType instanceof String = " + stringType instanceof String);

        // =============================================

        // 대입 연산자
        int variable = 5;
        System.out.println("variable : " + variable);

        // 산술 + 대입 연산자
        variable += 2;
        System.out.println("variable += 2 : " + variable);
        variable -= 2;
        System.out.println("variable -= 2 : " + variable);
        variable *= 2;
        System.out.println("variable *= 2 : " + variable);
        variable /= 2;
        System.out.println("variable /= 2 : " + variable);
        variable %= 2;
        System.out.println("variable %= 2 : " + variable);

        // 비트 + 대입 연산자
        variable &= 2;
        System.out.println("variable &= 2 : " + variable);
        variable |= 2;
        System.out.println("variable |= 2 : " + variable);
        variable ^= 2;
        System.out.println("variable ^= 2 : " + variable);
        variable <<= 2;
        System.out.println("variable ^= 2 : " + variable);
        variable >>= 2;
        System.out.println("variable ^= 2 : " + variable);
        variable >>>= 2;
        System.out.println("variable ^= 2 : " + variable);

        // =============================================

        // 삼항 연산자
        boolean setVariable = 1 == 1 ? true : false;

        String strVariable;
        strVariable = 1 != 1 ? "Hello" : "World !";

        System.out.println("setVariable = " + setVariable);
        System.out.println("strVariable = " + strVariable);

        // =============================================

        // 화살표 연산자
        Runnable r = new Runnable() {
            @Override
            public void run() {
            }
        };

        r = () -> { System.out.println("Hello World"); };
        r.run();
    }
}

//class Unit { }
//class Marine extends Unit { }
//class Medic  extends Unit { }
//class Starcraft {
//    public static void main(String[] args) {
//
//        Marine marine = new Marine();
//        Medic medic   = new Medic();
//
//        System.out.println("marine instanceof Unit = " + marine instanceof Unit);
//        System.out.println("medic instanceof Unit = "  + medic instanceof Unit);
//    }
//}

