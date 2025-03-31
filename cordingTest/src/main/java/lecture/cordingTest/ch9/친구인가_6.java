package lecture.cordingTest.ch9;

import java.util.Scanner;

/*
Disjoint-Set : Union&Find

학생의 친구관계를 나타내는 숫자쌍이 주어지면 특정 두 명이 친구인지를 판별하는 프로그램
을 작성하세요. 두 학생이 친구이면 “YES"이고, 아니면 ”NO"를 출력한다.


 ▣입력예제 1
9 7
1 2
2 3
3 4
1 5
6 7
7 8
8 9
3 8

▣출력예제 1
NO


20 22
18 9
4 15
12 16
9 10
10 7
14 9
13 3
17 5
6 1
1 14
12 4
9 11
7 5
17 4
6 17
12 9
18 10
17 8
11 18
7 19
4 3
3 4
10 15

YES
 */
public class 친구인가_6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] arr = new int[n + 1];
        for (int i=1; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int i1 = scanner.nextInt();
            int i2 = scanner.nextInt();
            union(arr, i1, i2);
        }

        int a = find(arr, scanner.nextInt());
        int b = find(arr, scanner.nextInt());
        System.out.println(a == b ? "YES" : "NO");
    }

    static void union(int[] arr, int a, int b) {
        int parentA = find(arr, a);
        int parentB = find(arr, b);
        arr[parentB] = parentA;
    }


    static int find(int[] arr, int i) {
        if (arr[i] == i) {
            return i;
        }
        return find(arr, arr[i]);
    }
}
