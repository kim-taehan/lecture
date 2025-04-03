package lecture.cordingTest.ch10;

import java.util.Arrays;
import java.util.Scanner;

/*
밑면이 정사각형인 직육면체 벽돌들을 사용하여 탑을 쌓고자 한다. 탑은 벽돌을 한 개씩 아래
에서 위로 쌓으면서 만들어 간다. 아래의 조건을 만족하면서 가장 높은 탑을 쌓을 수 있는 프
로그램을 작성하시오.
(조건1) 벽돌은 회전시킬 수 없다. 즉, 옆면을 밑면으로 사용할 수 없다.
 (조건2) 밑면의 넓이가 같은 벽돌은 없으며, 또한 무게가 같은 벽돌도 없다.
 (조건3) 벽돌들의 높이는 같을 수도 있다.
 (조건4) 탑을 쌓을 때 밑면이 좁은 벽돌 위에 밑면이 넓은 벽돌은 놓을 수 없다.
 (조건5) 무게가 무거운 벽돌을 무게가 가벼운 벽돌 위에 놓을 수 없다.

5
25 3 4
4 4 6
9 2 3
16 2 5
1 5 2

10
 */
public class 가장높은탑쌓기_4 {

    static class Block implements Comparable<Block> {
        int base;
        int height;
        int weight;

        public Block(int base, int height, int weight) {
            this.base = base;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Block o) {
            return o.base - this.base;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Block[] blocks = new Block[n];
        for (int i = 0; i < n; i++) {
            blocks[i] = new Block(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }

        int ret = solution(blocks);
        System.out.println(ret);
    }

    static int solution(Block[] blocks) {
        Arrays.sort(blocks);

        int answer = 0;
        int[] dy = new int[blocks.length];

        for (int i = 0; i < blocks.length; i++) {
            int max=0;
            for (int j = i - 1; j >= 0; j--) {
                if (blocks[j].weight > blocks[i].weight && dy[j] > max) {
                    max = dy[j];
                    if (answer == max) break;
                }
            }
            dy[i]=max+blocks[i].height;
            answer=Math.max(answer, dy[i]);

        }
        return answer;
    }



}
