# Dynamic Programming

- 두가지 속성을 만족해여 DP로 문제를 풀 수 있음
    1. Overlapping Subproblem 
        - 겹치는 부분이 있음

    2. Optimal Substructure 
        - 문제의 정답을 작은 문제의 정답에서 구할 수 있음
        - ex)
            - 서울에서 부산을 가는 가장 빠른 길이 대전과 대구를 순서대로 거쳐야 한다면
            - 대전에서 부산을 가는 가장 빠른 길은 대구를 거쳐야 함

- DP에서 각 문제는 한 번만 풀어야 함
- Optimal Substructure를 만족하기 때문에, 같은 문제는 구할 때마다 정답이 같음
- 따라서 정답을 한 번 구했으면, 정답을 어딘가에 메모해 놓음 `Memoization`
- 이런 메모하는 것을 코드의 구현에서는 배열에 저장하는 것으로 할 수 있음


## 피보나치 수
`F(n) = F(n-1) + F(n-2) (n>=2)`

1. Overlapping Subproblem
    - 문제 : n번째 피보나치 수를 구하는 문제
    - 작은 문제 : n-1번째 피보나치 수를 구하는 문제, n-2번째 피보나치 수를 구하는 문제
    - 큰 문제와 작은 문제를 같은 방법으로 풀 수 있음
    - 문제를 작은 문제로 쪼갤 수 있음

2. Optimal Substructure
    - 문제의 정답을 작은 문제의 정답을 합하는 것으로 구할 수 있음
    - Optimal Substructure를 만족한다면 문제의 크기에 상관없이 어떤 한 문제의 정답은 일정함


## DP를 푸는 두 가지 방법
1. Top-down
    - 큰 문제를 작게 만들어 나가며 푸는 방식
    - 보통 재귀로 구현
    - 순서
        1. 문제를 작은 문제로 나눈다.
        2. 작은 문제를 푼다.
        3. 문제를 푼다.
    - ex) 피보나치
        1. fibo(n-1)과 fibo(n-2)로 문제를 나눈다.
        2. fibo(n-1)과 fibo(n-2)를 호출해 문제를 푼다.
        3. fibo(n-1)의 값과 fibo(n-2)의 값을 더해 문제를 푼다.
    - 시간복잡도 : 채워야 하는 칸의 수(dp 배열의 수) * 한 칸을 채우는 복잡도

```python
dp = [0 for i in range(n)]

def fibo(n):
    if dp[n]:
        return dp[n]
    if n < 2:
        dp[n] = fibo(n-1) + fibo(n-2)
        return dp[n]
```

2. Bottom-up
    - 작은 문제부터 차례대로 푸는 방식
    - 문제의 크기를 조금씩 크게 만들면서 문제를 점점 푼다.
    - 작은 문제를 풀면서 왔기 때문에 큰 문제는 항상 풀 수 있다.
    - 보통 for문으로 구현 

```python
dp = [0 for i in range(n)]

def fibo(n):
    d[0] = 0;
    d[1] = 1;

    for i in range(2, n):
        dp[i] = dp[i-1] + dp[i-2]

    return d[n]
```


## 문제풀이 전략
- dp 배열에 무엇이 들어가야하는 지 정의
- 그것을 구하려면 어떤 식이 필요한지 -> 점화식
- 문제에서 구하려고 하는 답을 문장으로 나타낸다. 
- 문장에 나와있는 변수의 개수만큼 메모하는 배열을 만든다.
- Top-down인 경우에는 재귀 호출의 인자의 개수
- 문제를 작은 문제로 나누고, 수식을 이용해서 문제 표현


## 예제
### 파스칼의 삼각형
```python
# dp로 푼 것!!
for t in range(int(input())):
    n=int(input())
    p=[[1]]
    if n==2:
        p+=[[1,1]]
        print(p)
    elif n > 2:
        p += [[1,1]] +[[] for i in range(n - 2)]
        for i in range(2, n):
            for j in range(i+1):
                if j==0 or j==i:
                    p[i].append(1)
                else:
                    p[i].append(p[i-1][j-1]+p[i-1][j])
    print(f'#{t+1}')
    for i in p:print(*i)
```