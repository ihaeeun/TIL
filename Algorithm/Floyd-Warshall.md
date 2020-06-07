# Floyd-Warshall

> 모든 정점에서 모든 정점으로의 최단 경로를 구하는 알고리즘

- 각 정점이 다른 정점으로 가는 비용을 이차원 배열에 담아준다.
- 거쳐가는 정점을 기준으로 이차원 배열을 반복적으로 갱신하여 모든 최소 비용을 구한다.
- 예를 들어, 2->3 으로 바로가는 비용과, (2->1) + (1->3) 이런식으로 정점 1을 거쳐가는 경우를 비교해서 최소거리를 갱신한다.


### 시간복잡도
- 3중 for문을 사용하므로 O(n^3)

### 공간복잡도
- 특정 정점에서 특정 정점까지의 경로를 저장해나가며 구한 경로를 이용해 새로운 최단 경로를 찾는 DP방식으로 수행되므로 2차원 배열이 필요하므로 **O(V^2)**

```python
# n: node 개수, m: 간선 개수
n, m = map(int, input().split())

distance = [[0 if i==j else (1<<31-1) for i in range(n)] for j in range(n)]

# s1: 시작 노드, s2: 도착 노드, c: 가중치
for _ in range(m):
    s1, s2, c = map(int, input().split())
    distance[s1][s2] = int(c)


def floyd_warshall:
    # k: 거쳐가는 노드, i: 출발 노드, j: 도착 노드
    for k in range(n):
        for i in range(n):
            for j in range(n):
                if distance[i][j] > distance[i][k] + distance[k][j]:
                        distance[i][j] = distance[i][k] + distance[k][j]
```