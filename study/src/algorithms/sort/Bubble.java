package algorithms.sort;

import java.util.Arrays;

public class Bubble {

    /**
     * 버블정렬 - O(n^2)
     * -> 차순별로 두 값을 비교 및 교환하여 정렬하는 방법
     * - 오름차순(ascending), 내림차순(descending)별로 정렬이 가능
     * - 정렬 효율이 좋지 않다. (단순하지만 비효율적)
     */

    public static void main(String[] args) {

        int[] data = {6, 2, 5, 8, 3, 1, 7, 4, 9};

        int[] ascendingBubbleResult = ascendingBubble(data.clone());
        System.out.println("ascendingBubbleResult = " + Arrays.toString(ascendingBubbleResult));

        int[] descendingBubbleResult = descendingBubble(data.clone());
        System.out.println("descendingBubble = " + Arrays.toString(descendingBubbleResult));
    }

    public static int[] ascendingBubble(int[] data) {

        for (int i = 0; i < data.length - 1; i++) {

            for (int j = data.length - 1; j != i; j--) {

                int previousValue = data[j - 1];
                int currentValue  = data[j];

                if (previousValue > currentValue) {
                    int swapValue = previousValue;
                    data[j - 1]   = currentValue;
                    data[j]       = swapValue;
                }
            }
        }

        return data;
    }

    public static int[] descendingBubble(int[] data) {

        for (int i = data.length - 1; i > 0; i--) {

            for (int j = 0; j != i; j++) {

                int nextValue    = data[j + 1];
                int currentValue = data[j];

                if (nextValue > currentValue) {
                    int swapValue = nextValue;
                    data[j + 1]   = currentValue;
                    data[j]       = swapValue;
                }
            }
        }

        return data;
    }
}
