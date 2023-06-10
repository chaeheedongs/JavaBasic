package algorithms.searchs.arrays;

public class BinarySearchArray {

    /**
     * 이진 검색 ( Binary Search ) - O(log n)
     * -> 정렬된 데이터의 중간부터 검색
     * - 데이터가 정렬되어 있어 선형 검색보다 빠르다.
     */

    public static void main(String[] args) {

        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int result = binarySearchArray(data, 2);

        if (result == -1) {
            System.out.println("검색 실패 : " + result);
        }
        else {
            System.out.println("검색 성공 : " + result);
        }
    }

    public static int binarySearchArray(int[] data, int searchValue) {

        int startIndex  = 0;               // 시작 값
        int endIndex    = data.length - 1; // 배열의 첫 시작 인덱스는 0
        int centerIndex = 0;               // 중간 값

        while (true) {

            // 중간 값과 끝 값이 같으면,
            // 검색 실패
            if (centerIndex == endIndex) {
                return -1;
            }

            // 중간값은 시작값과 끝값을 더한 후 나누기 2
            centerIndex = (startIndex + endIndex) / 2;

            // 검색하려는 값과 데이터의 값이 같으면,
            // 해당 배열의 인덱스를 리턴
            if (searchValue == data[centerIndex]) {
                return centerIndex;
            }
            // 검색하려는 값이 크면,
            // 시작 인덱스는 중간 인덱스 + 1
            else if (searchValue > data[centerIndex]) {
                startIndex = centerIndex + 1;
            }
            // 검색하려는 값이 작으면,
            // 끝 인덱스는 중간 인덱스 - 1
            else if (searchValue < data[centerIndex]) {
                endIndex = centerIndex - 1;
            }
        }
    }
}
