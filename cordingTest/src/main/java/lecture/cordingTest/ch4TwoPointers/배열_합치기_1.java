package lecture.cordingTest.ch4TwoPointers;

import java.util.Scanner;

/*
오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.

3
1 3 5
5
2 3 6 7 9

1 2 3 3 5 6 7 9
 */
public class 배열_합치기_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrACnt = scanner.nextInt();
        int[] arrA = new int[arrACnt+1];
        for (int i = 0; i < arrACnt; i++) {
            arrA[i] = scanner.nextInt();
        }
        arrA[arrACnt] = Integer.MAX_VALUE;
        int arrBCnt = scanner.nextInt();
        int[] arrB = new int[arrBCnt+1];
        for (int i = 0; i < arrBCnt; i++) {
            arrB[i] = scanner.nextInt();
        }
        arrB[arrBCnt] = Integer.MAX_VALUE;
        int[] result = solution(arrACnt, arrA, arrBCnt, arrB);
        for (int i : result) {
            System.out.print(i+" ");
        }
    }

    private static int[] solution(int arrACnt, int[] arrA, int arrBCnt, int[] arrB) {
        int[] result = new int[arrACnt+arrBCnt];
        int aIndex = 0, bIndex = 0;
        for (int i = 0; i < result.length; i++) {
            if (arrA[aIndex] < arrB[bIndex]) {
                result[i] = arrA[aIndex++];
            }
            else {
                result[i] = arrB[bIndex++];
            }
        }
        return result;
    }
}
