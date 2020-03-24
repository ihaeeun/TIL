# PYTHON
## heapq
- 이진 트리 기반의 최소 힙 자료 구조 제공
- Java의 PriorityQueue
- min heap을 사용하면 원소들이 항상 정렬된 상태로 추가되고 삭제됨
- 가장 작은 값은 0번, 즉 이진트리의 루트에 위치
- 내부적으로 min heap 내의 모든 원소는 항상 자식 원소들보다 크기가 작거나 같도록 원소가 추가되고 삭제됨
```python
import heapq
```
- heapq 모듈은 파이썬의 리스트를 최소 힙처럼 다룰 수 있게 해줌


- 원소추가 : `heappush()`
- 원소삭제 : `heappop()`
- 최소값 : 인덱스[0]
- 리스트 > 힙 : `heapq.heapify()`

### 최대 힙
- 힙에 튜플을 원소로 추가하거나 삭제하면, 튜플 내에서 맨 앞에 있는 값을 기준으로 최소 힙이 구성되는 원리 이용
- 최대 힙을 만들려면 각 값에 대한 우선 순위를 구한 후, `(우선순위, 값)` 구조의 튜플을 힙에 추가하거나 삭제
```python
import heapq

nums = [4, 1, 7, 3, 8, 5]
heap = []

for num in nums:
    heapq.heappush(heap, (-num, num))  # (우선 순위, 값)

while heap:
    print(heapq.heappop(heap)[1])  # index 1
```