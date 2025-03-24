# 팰린드롬

# Two Pointers algorithm
- 리스트에 순차적으로 접근해야 할 때 두 개의 점의 위치를 기록하면서 처리하는 알고리즘
- 단 리스트는 정렬이 된상태에서 수행할 수 있다.
- [배열_합치기.java](src%2Fmain%2Fjava%2Flecture%2FcordingTest%2Fch2%2F%EB%B0%B0%EC%97%B4_%ED%95%A9%EC%B9%98%EA%B8%B0.java)
- [공통원소구하기.java](src%2Fmain%2Fjava%2Flecture%2FcordingTest%2Fch2%2F%EA%B3%B5%ED%86%B5%EC%9B%90%EC%86%8C%EA%B5%AC%ED%95%98%EA%B8%B0.java)
```java
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
```

# Sliding window
- 배열과 그 부분배열을 어떤 조건하에서 계산하는 경우에 주로 사용된다. 예를 들어, 구간 합 구하기, 부분 문자열 구하기등에 활용될 수 있다
![img.png](imgs/img.png)
- [최대매출.java](src%2Fmain%2Fjava%2Flecture%2FcordingTest%2Fch2%2F%EC%B5%9C%EB%8C%80%EB%A7%A4%EC%B6%9C.java)

```java
private static int solution(int n, int m, int[] arr) {
    int doSum = 0;
    for (int i = 0; i < m; i++) {
        doSum += arr[i];
    }
    int maxAmount = doSum;

    for (int i = m; i < n; i++) {
        doSum = doSum + arr[i] - arr[i - m];
        maxAmount = Math.max(doSum, maxAmount);
    }
    return maxAmount;
}
```

# 후위식 연산 
- 앞에 있는 값이 앞으로 들어가는 것만 주의하면 된다. 
- 352+*9- = 12
```java
private static int solution(String text) {
    Deque<Integer> stack = new ArrayDeque<>();
    for (char c : text.toCharArray()) {
        // 352+*9-
        if(Character.isDigit(c)) stack.push(c-48);
        else {
            int rt = stack.pop();
            int lt = stack.pop();
            if(c == '-') stack.push(lt-rt);
            else if(c == '+') stack.push(lt+rt);
            else if(c == '*') stack.push(lt*rt);
            else if(c == '/') stack.push(lt/rt);
        }
    }
    return stack.getFirst();
}
```
# 정렬
![img_1.png](imgs/sort.png)
## 선택정렬
- 선택 정렬(selection sort) 알고리즘
- 해당 순서에 원소를 넣을 위치는 이미 정해져 있고, 어떤 원소를 넣을지 선택하는 알고리즘
  첫 번째 순서에는 첫 번째 위치에 가장 최솟값을 넣는다.
  두 번째 순서에는 두 번째 위치에 남은 값 중에서의 최솟값을 넣는다.
```java
private static int[] solution(int n, int[] arr) {
    for (int i = 0; i < n - 1; i++) {
        int idx = i;
        for (int j = i + 1; j < n; j++) {
            if (arr[idx] > arr[j]) {
                idx = j;
            }
        }
        if (idx != i) {
            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }
    }
    return arr;
}
```

## 버블정렬
- 서로 인접한 두 원소를 검사하여 정렬하는 알고리즘
  인접한 2개의 레코드를 비교하여 크기가 순서대로 되어 있지 않으면 서로 교환한다.
- 주의사항: 회차 종료시마다 마지막 데이터가 정렬되는 방법이다. 
```java
private static int[] solution(int n, int[] arr) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n-i-1; j++) {
            if (arr[j] > arr[j+1]) {
                int temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp;
            }
        }
    }
    return arr;
}
```

## 삽입정렬
- 삽입 정렬은 두 번째 자료부터 시작하여 그 앞(왼쪽)의 자료들과 비교하여 삽입할 위치를 지정한 후 자료를 뒤로 옮기고 지정한 자리에 자료를 
  삽입하여 정렬하는 알고리즘이다.

```java
private static int[] solution(int n, int[] arr) {
  for (int i = 1; i < n; i++) {
    int temp = arr[i];
    int j = i-1;
    for (; j >= 0; j--) {
      if (arr[j] > temp) {
        arr[j+1] = arr[j];
      } else break;
    }
    arr[j+1] = temp;
  }
  return arr;
}
```

# 이분 탐색
- 이분 탐색이란 중간값을 기준으로 탐색의 범위를 설정하여 찾고자하는 값을 찾아내는 탐색법
- 

# 결정 알고리즘 
- 결정 알고리즘은 이분 탐색을 이용한 알고리즘
- 전재조건: 구하고자하는 값이 LT, RT 사이에 반드시 존재하는 경우 사용할 수 있다. 
- LT, RT 로 구한 MID 값이 답으로 사용할 수 있는가 없는 가를 확인하여 LT, RT 의 값을 변경하게 된다. 
```java
private static int solution(int size, int count, int[] arr) {
    int answer = 0;
    int rt = Arrays.stream(arr).sum();
    int lt = Arrays.stream(arr).max().getAsInt();
    while (lt <= rt) {

        int mid = (lt + rt) / 2;
        if (divide(arr, mid) <= count) {
            answer = mid;
            rt = mid - 1;
        } else {
            lt = mid + 1;
        }
    }
    return answer;
}
```

# 재귀 함수 (recursive)

- 팩토리얼 재귀함수
```java
private static int recursive(int n) {
  if(n <= 1) return 1;
  return recursive(n-1) * n;
}
```

## 이진트리 순회 
- 전위, 중위, 후위 순회 방법이 있으며, 부모 노드에 위치에 따라 이름이 붙일 수 있다. 
![img.png](imgs/이진트리.png)
```java
private static void 전위순회(Node node) {
    System.out.print(node.value + " ");
    if(node.left != null) 전위순회(node.left);
    if(node.right != null) 전위순회(node.right);
}

private static void 중위순회(Node node) {
    if(node.left != null) 중위순회(node.left);
    System.out.print(node.value + " ");
    if(node.right != null) 중위순회(node.right);
}

private static void 후위순회(Node node) {
    if(node.left != null) 후위순회(node.left);
    if(node.right != null) 후위순회(node.right);
    System.out.print(node.value + " ");
}
```

## 부분집합 
- 

# DFS : 깊이우선 탐색
- 너비우선 탐색 
![img.png](imgs/dfs.png)

# BFS : 넒이우선탐색: 레벨 탐색
- 레벨 탐색은 Que 를 사용한다. 

![img.png](imgs/bfs.png)

```java
private static void bfs(Node node) {
    Queue<Node> q = new LinkedList<>();
    q.offer(node);
    while (!q.isEmpty()) {
        int len = q.size();
        for (int i = 0; i < len; i++) {
            Node currentNode = q.poll();
            System.out.print(currentNode.value + " ");
            if(currentNode.left != null) q.offer(currentNode.left);
            if(currentNode.right != null) q.offer(currentNode.right);
        }
    }
}
```

# 그래프와 인접행렬
- 무방향 그래프 
![img.png](imgs/무방향그래프.png)

- 방향 그래프 
![img.png](imgs/방향그래프.png)

- 가중치 그래프

# ch8 
## 1 합이 같은 부분집합 (DFS)
> 설명
N개의 원소로 구성된 자연수 집합이 주어지면, 이 집합을 두 개의 부분집합으로 나누었을 때
두 부분집합의 원소의 합이 서로 같은 경우가 존재하면 “YES"를 출력하고, 그렇지 않으면 ”NO"를 출력하는 프로그램을 작성하세요.  
둘로 나뉘는 두 부분집합은 서로소 집합이며, 두 부분집합을 합하면 입력으로 주어진 원래의 집합이 되어 합니다.  
예를 들어 {1, 3, 5, 6, 7, 10}이 입력되면 {1, 3, 5, 7} = {6, 10} 으로 두 부분집합의 합이 16으로 같은 경우가 존재하는 것을 알 수 있다.

### 풀이
- DFS 알고리즘을 사용하여 처리하는 방식
- 전체 원소들의 합/2 를 먼저 찾는 작업을 수행한다.

### 주의사항
- index 가 전체 길이보다 길어지는것을 조심
- sum 이 홀수인 경우 문제자체가 성립되지 않는다. 

```java
public class 경로탐색_인접리스트_11 {

    private static List<Integer>[] graph;
    private static int[] history;
    private static int ret;
    private static int n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int trunk = scanner.nextInt();

        graph = new ArrayList[n + 1];//new int[n+1][n+1];
        history  = new int[n+1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= trunk; i++) {
            List<Integer> list = graph[scanner.nextInt()];

            list.add(scanner.nextInt());
        }
        history[1] = 1;
        dfs(1);
        System.out.println(ret);
    }

    private static void dfs(int node) {

        if (node == n) {
            ret++;
            return;
        }

        for (Integer i : graph[node]) {
            if (history[i] == 0) {
                history[i] = 1;
                dfs(i);
                history[i] = 0;
            }
        }
    }
}
```

## 2 바둑이 승자 DFS
### 설명
> 철수는 그의 바둑이들을 데리고 시장에 가려고 한다. 그런데 그의 트럭은 C킬로그램 넘게 태울수가 없다.  
철수는 C를 넘지 않으면서 그의 바둑이들을 가장 무겁게 태우고 싶다.  
N마리의 바둑이와 각 바둑이의 무게 W가 주어지면, 철수가 트럭에 태울 수 있는 가장 무거운 무게를 구하는 프로그램을 작성하세요.

### 풀이 
- DFS 로 깊이 탐색을 하면서 C 를 넘지않는 무게를 계속 측정한다. 
- 이 경우도 for 문 전체를 찾는 것이 아니라 다음 index 만 찾는 결정 알고리즘과 비슷

### 주의
- 제한조건을 걸다가 계속 빠지는 데이터가 발생할 수 있음
- 배열의 index 길이 고민

```java
private static void dfs(int index, int sum){
    if(index >= arr.length) return;
    int tempTotal = sum + arr[index];
    if (tempTotal <= max) {
        total = Math.max(total, tempTotal);
        dfs(index+1, tempTotal);
    }
    // 주의 tempTotal 생각하다가 이부분에서 계속 빠지는 데이터가 발생함 
    dfs(index+1, sum);
}
```
### 3 최대점수구하기
#### 설명
> 이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를 풀려고 합니다.  
    각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.  
    제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다.    
    (해당문제는 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)

#### 풀이
- 최대점수를 DFS 알고리즘을 사용하여 구하는 문제 
- score, min 배열을 따로 정의하는 것 이외에는 DPS 특이사항 없다. 

```java
private static void solution(int index, int score, int min) {
    if (min > m) return;
    if (index == scores.length) {
        answer = Math.max(answer, score);
    } else {
        solution(index+1, score+scores[index], min+mines[index]);
        solution(index+1, score, min);
    }
}
```
### 4 중복순열구하기 
#### 설명
> 1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열 하는 방법을 모두 출력합니다

#### 풀이
- dfs 방식을 사용하여 순차적으로 중복 순열을 추출한다. 

```java
static void dfs(int depth){
    if (depth == M) {
        addList();
    } else {
        for (int i = 1; i <= N; i++) {
            pm[depth] = i;
            dfs(depth + 1);
        }
    }
}
```

### 5 동전구하기
#### 설명
> 다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
각 단위의 동전은 무한정 쓸 수 있다.

#### 풀이 
- 가장 적은 수, 최소 몇번에 이런 문제는 BFS 를 사용하여 풀이할 수 있다. 
- 일반적인 문제와 차이점은 동일한 item 을 무한이 사용할 수 있다는 점이다.
```java
static int bfs() {
    Queue<Integer> arrayDeque = new ArrayDeque<>();
    int level = 0;
    for (int coin : coins) {
        arrayDeque.add(coin);
    }

    while (!arrayDeque.isEmpty()) {
        level++;
        int len = arrayDeque.size();
        for (int i = 0; i < len; i++) {
            Integer item = arrayDeque.poll();
            if (item == M) return level;
            // 거스름돈보다 큰경우에는 스킵한다.
            else if (item < M){
                for (int coin : coins) {
                    arrayDeque.add(item + coin);
                }
            }
            
        }
    }
    return 0;
}
```


### 6 순열구하기
> 10이하의 N개의 자연수가 주어지면 이 중  M개를 뽑아 일렬로 나열하는 방법을 모두 출력합니다.

#### 풀이 
- 중복 순열과 다르게 중복을 허용하지 않는 것만 조심하여 처리하면 된다. DFS 방식으로
- 배열이 아닌 리스트를 사용한 이유는 remove, contain 같은 Collection 메서드를 사용하기 위해 
- 입력 순서를 보장하는 Set을 사용해도 될 것 같아
- 배열 check 하는 데이터를 만들어서 처리해도 된다. (리스트 사용하지 않고..)

```java
static void dfs(int l, List<Integer> list) {

    if (l == M) {
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    } else {
        for (int i = 0; i < N; i++) {
            if(!list.contains(arr[i])){
                list.add(arr[i]);
                dfs(l + 1, list);
                list.remove(l);
            }
        }
    }
}
```

### 7 조합의 경우의 수
### 설명 
> 재귀를 이용해 조합수를 구해주는 프로그램을 작성하세요.

### 풀이 
- 중복 가능한 n개중에서 r개를 선택하는 경우의 수를 구하는 방법
- 별도의 공식이 존재하지만 재귀를 이용하여 조합수를 구할 수 있다. 
- r=1 으로 1개를 선택하는 경우 당연하게 n개의 방법이 존재
- n=r 인 경우에 예를 들어 3개중에서 3개를 선택하는 경우기에 1개 방법만 존재 
- 이를 이용하여 다음과 같이 풀이를 할 수 있다.
- 강의를 듣고 이전에 계산 값을 저장하는 배열만 추가하자

```java
static int recursion(int n, int r) {
    if(r == 1) return n;
    if(n == r) return 1;
    return recursion(n - 1, r - 1) + recursion(n - 1, r);
}
```