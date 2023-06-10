package exception;

public class ExceptionBasic {

    public static void main(String[] args) {

        // 일부러 에러를 생성
        // System.out.println(1/0);
        // Exception in thread "main" java.lang.ArithmeticException: / by zero at ExceptionBasic.main(ExceptionBasic.java:8)

        // =====================================================================

        try {
            // 일부러 에러를 생성
            System.out.println(1/0);
            // Exception in thread "main" java.lang.ArithmeticException: / by zero at ExceptionBasic.main(ExceptionBasic.java:15)
        } catch (Exception e) {
            // 에러가 발생하면 catch문 로직 처리
            System.out.println("에러가 발생하면 catch문이 실행됩니다.");
        }

        // =====================================================================

        try {
            // 일부러 에러를 생성
            System.out.println(1 / 0);
            // Exception in thread "main" java.lang.ArithmeticException: / by zero at ExceptionBasic.main(ExceptionBasic.java:26)
        } catch (ArithmeticException e) {
            // catch문을 여러번 선언할 수 있으며, Exception의 자식이 먼저 실행됩니다.
            System.out.print("catch문을 여러번 선언할 수 있으며, ");
            System.out.println("Exception의 자식이 먼저 실행됩니다.");
        } catch (Exception e) {
            // 에러가 발생하면 catch문 로직 처리
            System.out.println("에러가 발생하면 catch문이 실행됩니다.");
        }

        // =====================================================================

        try {
            // 일부러 에러를 생성
            System.out.println(1 / 0);
            // Exception in thread "main" java.lang.ArithmeticException: / by zero at ExceptionBasic.main(ExceptionBasic.java:41)
        } catch (ArithmeticException e) {
            // catch문을 여러번 선언할 수 있으며, Exception의 자식이 먼저 실행됩니다.
            System.out.print("catch문을 여러번 선언할 수 있으며, ");
            System.out.println("Exception의 자식이 먼저 실행됩니다.");
        } catch (Exception e) {
            // 에러가 발생하면 catch문 로직 처리
            System.out.println("에러가 발생하면 catch문이 실행됩니다.");
        } finally {
            // try ~ catch 로직이 종료된 후에
            // finally 로직 실행
            System.out.print("try ~ catch가 모두 실행된 후에, ");
            System.out.println("finally가 꼭 실행 됩니다.");
        }

        // =====================================================================

        try {
            throw new Exception("일부러 예외를 발생 시킵니다.");
        } catch (Exception e) {
            System.out.println("Exception : " + e.getClass().getName());
            System.out.println("  Message : " + e.getMessage());
            e.printStackTrace();
            // Exception : java.lang.Exception
            // Message : 일부러 예외를 발생
            // java.lang.Exception: 일부러 예외를 발생 at Package.ExceptionBasic.main(Main.java:60)
        }

        // =====================================================================

        try {
            // 일부러 예외를 발생시키는 메서드 호출
            occurException();
        } catch (Exception e) {
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
        }
    }

    // 해당 메서드 내용중 throw 로 예외를 발생 시키며,
    // 메서드 매개변수 옆에 throws 로 호출한 곳에 ( main:10 라인 )
    // 예외를 위임합니다.
    public static void occurException() throws Exception {
        throw new Exception("일부러 예외를 발생시킵니다.");
    }
}
