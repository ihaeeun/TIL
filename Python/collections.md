# PYTHON collections
## namedtuple
- tuple타입 subclass를 만들어주는 함수
- tuple은 index를 기준으로 접근하지만 namedtuple은 키를 가지고 접근할 수 있음
- key, value 형태로 값을 전송해야 하며 아닐 시 ValueError 발생

## OrderedDict
- 순서가 있는 dict
- 순서가 달라지면 동일하지 않은 객체가 됨

## Counter
- hash 가능한 객체를 카운트하는 dict
### 1. Counter()의 다양한 입력값들
1. List
    - list의 요소 개수를 collections.Counter()를 이용하여 구할 수 있음
    - 출력결과는 Dictionary 형태로 반환
    
2. Dictionary
    - 요소의 개수가 많은 것부터 출력
    - 결과값도 Dictionary 형태

3. 값 = 개수 형태
    - ex) Counter((a=2, b=3, c=2))

4. 문자열
    - {문자: 개수}의 딕셔너리 형태로 반환됨

```python
from collections import Collections

li = ['aa', 'cc', 'dd', 'aa', 'bb', 'ee']
print(Counter(li))
# Counter({'aa': 2, 'cc': 1, 'dd': 1, 'bb': 1, 'ee': 1})

dic = {'a': 3, 'b': 2, 'c': 4}
print(Counter(dic))
# Counter({'다': 4, '가': 3, '나': 2})

c = Counter(a=2, b=3, c=2)
print(Counter(c))
# Counter({'b': 3, 'c': 2, 'a': 2})
print(sorted(c.elements()))
# ['a', 'a', 'b', 'b,' 'b', 'c', 'c']

s = "aabcdeffgg"
print(Counter(s))
# Counter({'f': 2, 'g': 2, 'a': 2, 'e': 1, 'b': 1, 'c': 1, 'd': 1})
```


### 2. Counter의 메소드
1. update()
    - Counter의 값 갱신
    - 입력값을 문자열 형태로도 가능

2. elements()
    - 입력된 값의 요소에 해당하는 값을 풀어서 반환
    - 요소는 무작위로 반환하며 요소 수가 1보다 작을 경우 출력하지 않음
    - 대소문자를 구분하며, sorted()로 정렬 가능

3. most_common(n)
    - 입력된 값의 요소들 중 빈도수가 높은 순으로 상위 개를 리스트 안의 튜플 형태로 반환

4. subtract()
    - 요소를 뺌
    - 요소가 없는 경우 음수 출력

```python
from collections import Count

a = collections.Counter()
a.update("abcdefg")
print(a)
# Counter({'f': 1, 'e': 1, 'b': 1, 'g': 1, 'c': 1, 'a': 1, 'd': 1})
a.update({'f':3, 'e':2})
print(a)
# Counter({'f': 4, 'e': 3, 'b': 1, 'g': 1, 'c': 1, 'a': 1, 'd': 1})

b = Counter("Hello Python")
print(list(b.elements()))
# ['n', 'h', 'l', 'l', 't', 'H', 'e', 'o', 'o', ' ', 'y', 'P']

c = Counter("appel, orange, grape")
print(c.most_common())
# [('a', 3), ('p', 3), ('e', 3), ('g', 2), (',', 2), ('r', 2), (' ', 2), ('n', 1), ('l', 1), ('o', 1)]
print(c.most_common(3))
# [('a', 3), ('p', 3), ('e', 3)]

d1 = Counter('hello python')
d2 = Counter('i love python')
d1.subtract(d2)
print(d1)
# Counter({'l': 1, 'h': 1, 'n': 0, 't': 0, 'p': 0, 'e': 0, 'o': 0, 'y': 0, 'i': -1, 'v': -1, ' ': -1})
```
### 3. Counter를 이용한 연산
1. 덧셈
2. 뺄셈 : 음수값은 출력하지 않음
3. 교집합(&)과 합집합(|)
    - {값: 개수}의 딕셔너리 형태로 반환됨
```python
from collections import Counter
a = Counter('aabbccdd')
b = Counter('aabbce')

print(a&b)
# Counter({'b':2, 'a':2, 'c':1})
print(a|b)
# Counter({'b': 3, 'c': 2, 'd': 2, 'a': 2, 'e': 1})
```

## defaultdict
- 키가 없어도 에러를 출력하지 않고, dict에 기본값을 정의해 줌

## deque