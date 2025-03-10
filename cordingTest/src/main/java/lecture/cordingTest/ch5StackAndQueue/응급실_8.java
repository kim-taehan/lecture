package lecture.cordingTest.ch5StackAndQueue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/*
N명의 대기목록 순서의 환자 위험도가 주어지면, 대기목록상의 M번째 환자는 몇 번째로 진료를 받는지 출력하는 프로그램을 작성하세요

5 2
60 50 70 80 90

3

6 3
70 60 90 60 60 60

4

6 0
60 60 90 60 60 60

5

 */
public class 응급실_8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int cnt = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(solution(n, cnt, arr));
    }

    private static int solution(int n, int cnt, int[] arr) {
        int order = 0;

        Queue<Person> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            queue.offer(new Person(i, arr[i]));
        }
        while (!queue.isEmpty()) {
            Person item = queue.poll();
            for (Person person : queue) {
                if (item.order < person.order) {
                    queue.offer(item);
                    item = null;
                    break;
                }
            }
            if (item != null) {
                order++;
                if (item.id == cnt) {
                    return order;
                }
            }
        }

        return order;
    }

    static class Person {
        int id;
        int order;

        public Person(int id, int order) {
            this.id = id;
            this.order = order;
        }
    }
}
