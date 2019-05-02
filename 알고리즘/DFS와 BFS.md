# **그래프** 
정점(Vertex)과 간선(Edge)로 이루어져 있는 자료구조

### 그래프를 표현하는 방법
#### 1. 인접 행렬
**`그래프의 상태를 나타내는 정사각행렬`**  
그래프의 정점이 n개일 때 n*n의 이차원 배열로 나타낼 수 있다.  
정점 간의 간선이 존재하면 1로, 존재하지 않으면 0으로 나타낸다.  
가중치가 있는 경우 1대신 가중치를 넣으면 된다.

> **ex)**  
a[1][5] = 1  
>> 정점 1과 정점 5의 간선이 연결되어 있다는 의미.
    

```java
// 인접행렬은 일반적으로 a라고 이름을 짓는다.
int a[][] = new int[n+1][n+1];

for(int i = 0; i < n; i++){
    int v1 = s.nextInt();
    int v2 = s.nextInt();

    a[v1][v2] = 1;
    a[v2][v1] = 1;
}
```
<br>

#### 2. 인접 리스트
**`한 정점과 연결되어 있는 모든 정점들을 하나의 연결리스트로 표현하는 방식`**  
그래프의 각 정점마다 해당 정점에서 나가는 간선의 목록을 저장하여 표현한다.  
인접행렬에 비해 간선이 적은 그래프에 유용  

> **ex)**  
    1에 연결되어 있는 간선들을 A[1]에 저장하고, A[2]에는 2에 연결되어 있는 간선을 저장한다.

```java
ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n+1];

for(int i = 0; i <= n; i++){
    int v1 = s.nextInt();
    int v2 = s.nextInt();

    a[v1].add(v2);
    a[v2].add(v1);
}
```
인접행렬의 경우 크기가 정점과 간선의 개수와 상관없이 (정점 개수)*(정점 개수)이기 때문에 공간복잡도가 O(v^2)이다.  
하지만 인접리스트는 필요한 공간만 쓰기 때문에 O(v+e)가 된다.  

<br>

## DFS와 BFS
두 방식의 목표는 모든 정점을 한 번만 탐색하는 것이다. 따라서 탐색 여부를 확인하기 위한 check 배열이 필요하다.
### **DFS** (Depth Fisrt Search, 깊이 우선 탐색)
일반적으로 인접행렬을 이용한 **재귀행렬**을 사용하여 구현하고, **스택**을 사용할 수도 있다.  
부모 노드로 돌아오는 과정을 **백트래킹**(Backtracking)이라고 한다.  

#### 장점
- 현 경로 상의 노드만 기억하면 되므로 저장공간의 수요가 적다.
- 목표 노드가 깊은 단계에 있는 경우 해를 빨리 구할 수 있다.

#### 단점
- 해가 없는 경로에 깊이 빠질 수 있다.   
  따라서 **깊이제한**을 지정하여 해당 깊이까지만 탐색하고, 목표 노드를 발견하지 못하면 다음 경로를 따라 탐색하도록 하는 것이 좋다.
- 얻어진 해가 최단 경로가 된다는 보장이 없다.  
  목표까지의 경로가 다수인 경우 깊이 우선 탐색은 해에 다다르면 탐색을 끝내버린다.  


#### 인접 행렬을 이용한 구현
```java
// a: 인접행렬, c: 방문여부, v: 정점
public static void dfs(int[][] a, boolean[] c, int v){
    int n = a.length -1;
    c[v] = true;
    System.out.prirnt(v + " ");

    for(int i = 1; i <= n; i++){
        if(a[v][i] == 1 && !c[i]) {
            dfs(a, c, i);
        }
    }
}
```

#### 스택을 이용한 구현
```java
public static void dfs(int[][] a, boolean[] c, int v, boolean flag) {
    Stack<Integer> stack = new Stack<>();
    int n = a.length -1;

    stack.push(v);
    c[v] = true;
    System.out.prirnt(v + " ");

    while(!stack.isEmpty()){
        int vv = stack.peek();

        flag = false;

        for(int i = 1; i <= n; i++) {
            if(a[vv])[i] == 1 && !c[i]) {
                stack.push(i);
                System.out.prirnt(i + " ");

                c[i] = true;
                flag = true;
                break;
            }
        }
        if(!flag){
            stack.pop();
        }
    }
}
```
1. 스택의 top에 있는 정점을 기준으로 간선이 연결되어 있고 아직 방문하지 않은 정점을 찾는다.
2. 조건에 맞는 정점을 찾는다면 해당 정점을 스택에 넣은 후 break를 건다.  
=> DFS 탐색이 진행됨. 현재 정점을 기준으로 탐색 중 조건에 맞는 정점을 찾는다면 그 정점을 기준으로 다시 탐색하는 것을 반복
3. 연결된 간선이 없고, 방문하지 않은 정점을 찾지 못한다면 pop.
=> 다시 돌아가기 위해

<br>

### **BFS** (Breadth First Search, 너비 우선 탐색)
더 이상 방문하지 않은 정점이 없을 때까지 방문하지 않은 모든 정점들에 대해서 적용한다. 일반적으로 **큐**를 사용하여 구현한다.

#### 장점
- 출발 노드에서 목표 노드까지의 최단 길이 경로를 보장한다.

#### 단점
- 경로가 매우 길 경우 탐색 가지가 급격히 증가하여 많은 기억 공간을 필요로 한다.
- 해가 존재하지 않는 유한 그래프의 경우 모든 그래프를 탐색한 후 실패로 끝난다.
- 무한 그래프의 경우 끝낼 수 없다. 

#### 인접행렬을 이용한 구현
```java
public static void bfs(int[][] a, boolean[] c, int v){
    Queue<Integer> q = new LinkedList<>();
    int n = a.length - 1;

    q.add(v);
    c[v] = true;

    while(!q.isEmpty()){
        v = q.poll();
        System.out.prirnt(v + " ");

        for(int i = 1; i <= n; i++){
            if(a[v][i] == 1 && !c[i]){
                q.add(i);
                c[i] = true;
            }
        }
    }
}
```
1. 큐의 front인 정점을 기준으로 연결된 간선이 있고, 방문하지 않은 정점을 찾는다. 
2. 조건에 맞는 정점은 모두 큐에 넣는다.  

위 과정을 반복한다.  

DFS의 경우 break문을 걸었지만 BFS는 모두 큐에 넣음으로써 너비를 기준으로 탐색한다.  
따라서 모든 경우를 탐색할 수 있게 됨으로써, 최단 경로에 이용할 수 있게 된다.

#### 인접리스트를 이용한 구현
```java
while(!q.isEmpty()){
    v=q.poll();
    System.out.print(v + " ");

    for(int vv : a[v]){
        if(!c[vv]){
            q.add(vv);
            c[vv] = true;
        }
    }
}
```
인접 행렬의 경우 정점을 탐색하는 과정에서 무조건 1에서 n까지 루프를 돌았다.  
인접 리스트의 경우에는 리스트 특성상 각 리스트마다 존재하는 정점만큼 존재한다.  
따라서 i에서 n까지 돌지 않아도 되고, 존재하는 만큼만 탐색하면 되기 때문에 시간복잡도 측면에서도 효율적이다.  

[참고]   
https://wanna-b.tistory.com/64  
https://mygumi.tistory.com/102