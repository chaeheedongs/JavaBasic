package junit.threads;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;

public class Step2_Callable {

    /**
     * Runnable: 반환 값이 없음
     * Callable: Callable<V> 즉 반환 값이 있음 / 파라미터는 받지 않음
     */
    @Test
    void callable_whenCallParameterVoid_thenReturnVoid() throws Exception {
        Callable<Void> task = () -> {
            System.out.println("Hello");
            return null; // 반환값 명시
        };

        task.call();
    }

    @Test
    void callable_whenCallParameterString_thenReturnString() throws Exception {
        Callable<String> task = () -> "Hello Callable";

        String callResult = task.call();
        System.out.println("callResult = " + callResult);
    }
}
