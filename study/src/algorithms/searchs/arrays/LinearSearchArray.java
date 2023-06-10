package algorithms.searchs.arrays;

public class LinearSearchArray {

    /**
     * 선형 검색 ( Linear Search ) - O(n)
     * -> 원하는 키를 만날 때 까지 처음부터 끝까지 검색
     * - 정렬이 되어 있지 않은 데이터를 검색
     */

    public static void main(String[] args) {

        int[] data = {2, 5, 1, 3, 4, 6, 8, 7};
        int result = linearSearchArray(data, 8);

        // 검색 실패
        if (result == -1) {
            System.out.println("검색 실패 : " + result);
        }
        // 검색 성공
        else {
            System.out.println("검색 성공 : " + result);
        }
    }

    public static int linearSearchArray(int[] data, int searchValue) {

        int index = 0;

        while (true) {

            // index가 배열의 크기만큼 검색했을때 없으면 -1 리턴
            // 즉, 전체 검색 실패시 -1 리턴
            if (index == data.length) {
                return -1;
            }

            // 검색하려는 값과 데이터의 값이 같으면,
            // 해당 배열의 인덱스를 리턴
            else if (searchValue == data[index]) {
                return index;
            }

            // 위 조건이 맞지 않으면 인덱스 1 증가
            index = index + 1;
        }
    }
}
