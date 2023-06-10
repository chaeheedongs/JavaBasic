package variable;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class VariableBasic {

    /**
     * 상수
     */

    static final String BRONZE_GRADE   = "BRONZE";
    static final String SILVER_GRADE   = "SILVER";
    static final String GOLD_GRADE     = "GOLD";
    static final String PLATINUM_GRADE = "PLATINUM";
    static final String DIA_GRADE      = "DIA";
    static final String MASTER_GRADE   = "MASTER";

    /**
     * 자료형 [Primitive]
     */
    public static void primitiveType() {

        byte    byteVariable    = 0;
        short   shortVariable   = 0;
        int     intVariable     = 0;
        long    longVariable    = 0;
        float   floatVariable   = 0.0f;
        double  doubleVariable  = 0.0;
        char    charVariable    = ' ';
        boolean booleanVariable = false;

        System.out.println("[정수] byteVariable   : " + byteVariable);
        System.out.println("[정수] shortVariable  : " + shortVariable);
        System.out.println("[정수] intVariable    : " + intVariable);
        System.out.println("[정수] longVariable   : " + longVariable);
        System.out.println("[실수] floatVariable  : " + floatVariable);
        System.out.println("[실수] doubleVariable : " + doubleVariable);
        System.out.println("[문자] charVariable   : " + charVariable);
        System.out.println("[논리] booleanVariable: " + booleanVariable);
    }


    /**
     * 자료형 [Reference]
     * - Primitive Type 을 제외한 나머지
     */
    public static void referenceType() {

        String stringVariable = "This is String";
        LocalDate localDateVariable = LocalDate.now();
        LocalDateTime localDateTimeVariable = LocalDateTime.now();

        System.out.println("[객체] stringVariable : " + stringVariable);
        System.out.println("[객체] localDateVariable : " + localDateVariable);
        System.out.println("[객체] localDateTimeVariable : " + localDateTimeVariable);
    }


    /**
     * 배열 [Array]
     * - 1차원
     * - 2차원
     */
    public static void array() {

        // 1차원 배열 - 선언과 동시에 할당
        int[] intArr1 = new int[]{0, 1, 2, 3, 4};
        System.out.println("intArr1[0]  = " + intArr1[0]);
        System.out.println("intArr1[1]  = " + intArr1[1]);
        System.out.println("intArr1[2]  = " + intArr1[2]);
        System.out.println("intArr1[3]  = " + intArr1[3]);
        System.out.println("intArr1[4]  = " + intArr1[4]);

        // 1차원 배열 - 선언후 하나씩 할당
        int[] intArr2 = new int[5];
        intArr2[0] = 0;
        intArr2[1] = 1;
        intArr2[2] = 2;
        intArr2[3] = 3;
        intArr2[4] = 4;
        System.out.println("intArr2[0]  = " + intArr2[0]);
        System.out.println("intArr2[1]  = " + intArr2[1]);
        System.out.println("intArr2[2]  = " + intArr2[2]);
        System.out.println("intArr2[3]  = " + intArr2[3]);
        System.out.println("intArr2[4]  = " + intArr2[4]);

        // 2차원 배열 - 길이 추정
        int[][] intArr3 = new int[][]{{0, 1}, {2, 3}};
        System.out.println("intArr3[0][0]  = " + intArr3[0][0]);
        System.out.println("intArr3[0][1]  = " + intArr3[0][1]);
        System.out.println("intArr3[1][0]  = " + intArr3[1][0]);
        System.out.println("intArr3[1][1]  = " + intArr3[1][1]);

        // 2차원 배열 - 길이 지정
        int[][] intArr4 = new int[2][2];
        intArr4[0][0] = 0;
        intArr4[0][1] = 1;
        intArr4[1][0] = 2;
        intArr4[1][1] = 3;
        System.out.println("intArr4[0][0]  = " + intArr4[0][0]);
        System.out.println("intArr4[0][1]  = " + intArr4[0][1]);
        System.out.println("intArr4[1][0]  = " + intArr4[1][0]);
        System.out.println("intArr4[1][1]  = " + intArr4[1][1]);
    }


    /**
     * 타입추론 var
     * - Java 10 부터 사용 가능
     * - Java 11 부터 Lambda 사용 가능
     */
    public static void varKeyword() {
//        var foo;        // Cannot infer type: 'var' on variable without initializer
//        var foo = null; // Variable 'foo' is already defined in the scope
        var foo = "hello foo";

        if (foo instanceof String) {
            System.out.println("var : " + foo);
        }
    }


    public static void main(String[] args) {

        primitiveType();
        referenceType();
        array();
        varKeyword();

        /**
         * 상수
         * - 클래스 필드에 선언되어 있음
         */
        System.out.println("[상수] BRONZE_GRADE : "   + BRONZE_GRADE);
        System.out.println("[상수] SILVER_GRADE : "   + SILVER_GRADE);
        System.out.println("[상수] GOLD_GRADE : "     + GOLD_GRADE);
        System.out.println("[상수] PLATINUM_GRADE : " + PLATINUM_GRADE);
        System.out.println("[상수] DIA_GRADE : "      + DIA_GRADE);
        System.out.println("[상수] MASTER_GRADE : "   + MASTER_GRADE);
    }
}
