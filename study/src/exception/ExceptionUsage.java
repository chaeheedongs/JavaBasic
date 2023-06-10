package exception;

/**
 * 자바에서 예외 처리 방법 (try, catch, throw, throws, finally)
 */

public class ExceptionUsage {

    public static void main(String[] args) {

        /**
         * 예외 발생 시키기
         * - 숫자를 나누는 예제
         * - java.lang.ArithmeticException
         */
//        int arithmeticException = 1 / 0; // <-- ArithmeticException 발생
//        System.out.println("예외 발생 이후 로직");
        // =====================================================================
        // Exception in thread "main" java.lang.ArithmeticException: / by zero
        // at exception.ExceptionUsage.main(ExceptionUsage.java:15)
        // =====================================================================


        /**
         * 예외를 try ~ catch로 감싸기
         * - 문제가 되는 코드를 예외 처리 하기
         */
//        try {
//            int arithmeticException = 1 / 0; // <-- ArithmeticException 발생
//            System.out.println("예외 발생 이후 로직");
//        } catch (Exception e) {
//            System.out.println("예외를 catch 하였습니다.");
//        }
        // =====================================================================
        // 예외를 catch 하였습니다.
        // =====================================================================


        /**
         * 다중 catch 테스트
         * - 예외별로 catch 하여 예외를 처리할 수 있다.
         * - catch문은 위에서 아래 방향으로 작은 예외에서 큰 예외로 이동 한다.
         */
//        try {
//            int arithmeticException = 1 / 0; // <-- ArithmeticException 발생
//            System.out.println("예외 발생 이후 로직");
//        } catch (IllegalArgumentException | IllegalStateException e) {
//            System.out.println("IllegalArgumentException 또는 IllegalStateException 예외 발생 !!");
//        } catch (ArithmeticException e) {
//            System.out.println("ArithmeticException 발생 !!");
//        } catch (Exception e) {
//            System.out.println("예외를 catch 하였습니다.");
//        }
        // =====================================================================
        // ArithmeticException 발생 !!
        // =====================================================================


        /**
         * finally로 이후 로직 작성하기
         * - 예외 처리 후 필수적으로 처리해야 할 로직이 있으면 추가 한다.
         */
//        try {
//            int arithmeticException = 1 / 0; // <-- ArithmeticException 발생
//            System.out.println("예외 발생 이후 로직");
//        } catch (IllegalArgumentException | IllegalStateException e) {
//            System.out.println("IllegalArgumentException 또는 IllegalStateException 예외 발생 !!");
//        } catch (ArithmeticException e) {
//            System.out.println("ArithmeticException 발생 !!");
//        } catch (Exception e) {
//            System.out.println("예외를 catch 하였습니다.");
//        } finally {
//            System.out.println("try ~ catch 이후 실행 로직 작성");
//        }
        // =====================================================================
        // ArithmeticException 발생 !!
        // try ~ catch 이후 실행 로직 작성
        // =====================================================================


        /**
         * throw 키워드로 일부로 예외 발생 하기
         * - createIllegalStateException() 메서드 호출
         */
//        createIllegalStateException();
        // =====================================================================
        // Exception in thread "main" java.lang.IllegalStateException
        // at exception.ExceptionUsage.createIllegalStateException(ExceptionUsage.java:94)
        // at exception.ExceptionUsage.main(ExceptionUsage.java:85)
        // =====================================================================


        /**
         * throws 키워드로 호출한 곳으로 예외를 던지기
         * - createArithmeticException() 메서드 호출
         * - ArithmeticException 예외가 발생하였지만 throws 키워드로 예외 이전
         * - 호출한 곳에서 예외를 처리
         */
//        try {
//            createArithmeticException();  // <-- 호출한 곳에서 예외를 받음 no.2
//        } catch (ArithmeticException e) { // <-- 예외를 처리 no.3
//            System.out.println("ArithmeticException 발생 !!");
//        } catch (Exception e) {
//            System.out.println("예외를 catch 하였습니다.");
//        }
        // =====================================================================
        // ArithmeticException 발생 !!
        // =====================================================================


        /**
         * 커스텀 예외 호출
         */
        try {
            createExceptionCustom();  // <-- 호출한 곳에서 예외를 받음 no.2
        } catch (ExceptionCustom e) { // <-- 예외를 처리 no.3
            System.out.println("custom 예외를 catch 하였습니다.");
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException 발생 !!");
        } catch (Exception e) {
            System.out.println("예외를 catch 하였습니다.");
        }
        // =====================================================================
        // custom 예외를 catch 하였습니다.
        // =====================================================================
    }

    public static void createIllegalStateException() {
        /**
         * 일부로 IllegalStateException 발생 시키기
         */
        boolean condition = true;
        if (condition) {
            throw new IllegalStateException(); // <-- IllegalStateException 발생 후 종료
        }
    }

    public static void createArithmeticException() throws ArithmeticException {
        boolean condition = true;
        if (condition) {
            throw new ArithmeticException(); // <-- ArithmeticException 발생 no.1
        }
    }

    public static void createExceptionCustom() throws ExceptionCustom {
        boolean condition = true;
        if (condition) {
            throw new ExceptionCustom(); // <-- ExceptionCustom 발생 no.1
        }
    }
}
