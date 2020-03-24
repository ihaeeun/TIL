#PYTHON
```python
import queue
```

## 클래스
1. queue.Queue(maxsize) : FIFO 큐 객체 생성
2. queue.LifoQueue(maxsize) : LIFO 큐 객체 생성(스택)
3. queue.PriorityQueue(maxsize) : 우선순위 큐 객체 생성. 입력되는 아이템 형식은 (순위, 아이템)의 튜플로 입력되며, 우선순위는 숫자가 작을 수록 높은 순위

## 메소드
1. qsize() : 큐 객체에 입력된 아이템의 개수 반환
2. put(item[, block[, timeout]]) : 큐 객체에 아이템 입력
3. put_nowait(item) : 블로킹 없이 큐 객체에 아이템 입력. 큐가 꽉 차있는 경우 queue.Full 예외 발생
4. get_nowait(item) : 블로킹 없이 큐 객체에 들어있는 아이템 반환. 큐에 아이테이 없는 경우 queue.Empty 예외 발생

