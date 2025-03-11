package junit.threads;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import static org.assertj.core.api.Assertions.assertThat;

public class Step4_ForkJoin {

    /**
     * java.lang.Object
     *     java.util.concurrent.ForkJoinTask<Void>
     *         java.util.concurrent.RecursiveAction
     *             implemented Serializable, Future<Void>
     *
     * java.lang.Object
     *     java.util.concurrent.ForkJoinTask<V>
     *         java.util.concurrent.RecursiveTask<V>
     *             implemented Serializable, Future<Void>
     */
    static class ForkJoinClass extends RecursiveTask<Long> {

        private final int from;
        private final int to;

        public ForkJoinClass(final int from,
                             final int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            final int middle = (this.from + this.to) / 2;
            long total = 0;

            /* 작업 단위가 작으면 단일 스레드로 처리 */
            if (middle < 100) {
                for (int index = 0; index < this.to; index++) {
                    total = total + index;
                }
                return total;
            }

            /* 작업 단위가 크면 ForkJoin 처리 - 작업을 2개로 나누어 작업함 */
            ForkJoinClass task1 = new ForkJoinClass(this.from, middle);
            task1.fork();

            ForkJoinClass task2 = new ForkJoinClass(middle + 1, this.to);

            total = task1.compute() + task2.join();

            return total;
        }
    }

    @Test
    void test_whenSingleThreadAddNumbers_thenReturnSumNumber() {

        int size = 1000;
        long total = 0;

        for (int index = 0; index < size; index++) {
            total = total + index;
        }

        assertThat(total).isEqualTo(499500);
    }

    @Test
    void test_whenForkJoinAddNumbers_thenReturnSumNumber() {
        ForkJoinClass forkJoinClass = new ForkJoinClass(0, 1000);

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Long result = forkJoinPool.invoke(forkJoinClass);

        assertThat(result).isEqualTo(499500);
    }
}
