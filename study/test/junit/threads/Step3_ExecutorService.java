//package junit.threads;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//import java.util.concurrent.Callable;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.Future;
//
//public class Step3_ExecutorService {
//
//    @Test
//    void executors_factoryBean_test() {
//        /* 단일 스레드 */
//        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
//
//        /* 고정 스레드 */
//        ExecutorService fixedExecutorService = Executors.newFixedThreadPool(10);
//
//        /* 스레드 풀에서 남는 스레드 */
//        ExecutorService cachedExecutorService = Executors.newCachedThreadPool();
//
//        /* 스케쥴 스레드 */
//        ExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
//
//        /* 종료 */
//        singleThreadExecutor.shutdown();
//        fixedExecutorService.shutdown();
//        cachedExecutorService.shutdown();
//        scheduledExecutorService.shutdown();
//    }
//
//    @Test
//    void executor_service_submit_test() throws Exception {
//        final Callable<Void> task = () -> {
//            System.out.println("hello void task");
//            return null;
//        };
//
//        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
//        Future<Void> future = singleThreadExecutor.submit(task);// 작업 등록
//        future.get(); // 작업 실행
//        boolean isDone = future.isDone(); // 작업 처리 결과 확인 [ true, false ] / get() 호출 안하면 false
//        singleThreadExecutor.shutdown();
//
//        System.out.println("isDone = " + isDone);
//    }
//
//    @Test
//    void executor_service_invokeAll_test() throws Exception {
//        final Callable<String> task1 = () -> "hello task";
//        final Callable<String> task2 = () -> "hello task2";
//
//        ExecutorService fixedExecutorService = Executors.newFixedThreadPool(2);
//        List<Future<String>> futures = fixedExecutorService.invokeAll(List.of(task1, task2));
//        for (Future<String> future : futures) {
//            final String result = future.get();
//            final boolean isDone = future.isDone();
//            System.out.println("result = " + result);
//            System.out.println("isDone = " + isDone);
//            System.out.println();
//        }
//
//        fixedExecutorService.shutdown();
//    }
//
//    @Test
//    void executor_service_invokeAny_test() throws Exception {
//        final Callable<String> task1 = () -> "hello task";
//        final Callable<String> task2 = () -> "hello task2";
//
//        ExecutorService fixedExecutorService = Executors.newFixedThreadPool(2);
//        String result = fixedExecutorService.invokeAny(List.of(task1, task2));
//        System.out.println("result = " + result);
//
//        fixedExecutorService.shutdown();
//    }
//}
