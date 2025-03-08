package lecture.cordingTest.ch2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.

5
1 3 9 5 2
5
3 2 5 7 8

2 3 5
 */
public class 공통원소구하기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrACnt = scanner.nextInt();
        int[] arrA = new int[arrACnt];
        for (int i = 0; i < arrACnt; i++) {
            arrA[i] = scanner.nextInt();
        }
        int arrBCnt = scanner.nextInt();
        int[] arrB = new int[arrBCnt];
        for (int i = 0; i < arrBCnt; i++) {
            arrB[i] = scanner.nextInt();
        }
        List<Integer> result = solution(arrACnt, arrA, arrBCnt, arrB);
        for (int i : result) {
            System.out.print(i+" ");
        }
    }

    private static List<Integer> solution(int arrACnt, int[] arrA, int arrBCnt, int[] arrB) {

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        List<Integer> answer = new ArrayList<>();

        int indexA = 0, indexB = 0;
        while(indexA < arrACnt && indexB < arrBCnt) {

            if (arrA[indexA] == arrB[indexB]) {
                answer.add(arrA[indexA++]);
                indexB++;
            }
            else if (arrA[indexA] > arrB[indexB]) {
                indexB++;
            } else {
                indexA++;
            }
        }
        return answer;
    }

}
