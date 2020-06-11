# Collections Framework
## 1. 컬렉션 프레임워크의 핵심 인터페이스
- 데이터 군을 저장하는 클래스들을 표준화한 설계   
- 필요한 기능을 가진 3개의 인터페이스로 정의.
    > List  
    > Set  
    > Map  
- List와 Set을 구현한 컬렉션 클래스들은 서로 많은 공통부분이 있어 Collection 인터페이스에서 상속받음


| 인터페이스 | 특징 | 구현클래스  
| :-----: | :----- | :----- | 
|List| 순서가 있는 데이터의 집합. 데이터 중복 허용. | ArrayList, LinkedList, Stack, Vector 등
|Set| 순서를 유지하지 않는 데이터 집합. 데이터 중복 불허. | HashSet, TreeSet 등
|Map| 키(key)와 값(value)의 쌍(pair)으로 이루어진 데이터 집합. 순서는 유지되지 않으며, 키는 중복을 허용하지 않고, 값은 중복을 허용 | HashMap, TreeMap, Hashtable, Properties 등

 
### Collection 인터페이스
List와 Set의 조상으로 컬렉션 클래스에 저장된 데이터를 읽고, 추가하고 삭제하는 등 컬렉션을 다루는 가장 기본적인 메소드가 정의되어 있다.

### List 인터페이스
중복을 허용하면서 저장순서가 유지되는 컬렉션 구현

### Set 인터페이스
- 중복을 허용하지 않고 저장순서가 유지되지 않는 컬렉션 클래스 구현

### Map 인터페이스
- 키와 값을 하나의 쌍으로 묶어서 저장하는 컬렉션 클래스 구현
- 키는 중복될 수 없지만 값은 중복 허용
- 기존에 저장된 데이터와 중복된 키와 값을 저장하면 기존 값은 없어지고 마지막에 저장된 값이 남음
- values() 반환타입은 Collection
- keySet() 반환 타입은 Set -> 중복을 허용하지 않기 때문에 Set 타입으로 반환

### Map.Entry 인터페이스
- Map 인터페이스의 내부 인터페이스
- Map에 저장되는 key-value 쌍을 다루기 위해 내부적으로 Entry 인터페이스를 정의해 놓은 것
```java
public interface Map {
    ...
    interface Entry {
        Object getKey();
        Object getValue();
        Object setValue();
        boolean equals(Object o);
        int hashCode();
        ...
    }
}
```
<br><br>

## 2. ArrayList
- 특징
    - Object 배열을 이용해 데이터를 순차적으로 저장  
    - 배열에 더 이상 저장할 공간이 없으면 보다 큰 새로운 배열을 생성해서 기존 배열에 저장된 내용을 새로운 배열로 복사한 뒤 저장된다.
    - 삭제 연산이 일어나는 경우 배열의 끝에서부터 탐색해야 함
- Vector의 용량과 크기
    - ArrayList나 Vector 같이 배열을 이용한 자료구조는 데이터를 읽어오고 저장하는 데에는 효율이 좋음
    - 하지만 용량을 변경해야 할때는 새로운 배열을 생성한 후 기존의 배열로부터 새로 생성된 배열로 데이터를 복사해야하기 때문에 효율이 떨어진다.
- Array 클래스 내부
    - remove 구현 방법
        1. 삭제할 데이터의 아래에 있는 데이터를 한 칸씩 위로 복사해서 삭제할 데이터를 덮어 씀
        2. 데이터가 모두 한 칸씩 위로 이동하였으므로 마지막 데이터 null로 변경
        3. 데이터가 삭제되어 데이터의 개수가 줄었으므로 size 값을 1 감소시킴

        -> 배열에 객체를 순차적으로 저장할 때와 객체를 마지막에 저장된 것부터 삭제하면 `System.arraycopy()`를 호출하지 않기 때문에 작업시간이 짧지만, 배열의 중간에 위치한 객체를 추가하거나 삭제하는 경우 `System.arraycopy()`를 호출해서 다른 데이터의 위치를 이동시켜 줘야 하기 때문에 데이터가 많을 수록 시간이 오래 걸린다.

<br><br>

## 3. LinkedList
- 기본 원리
    - 배열의 단점 : 크기 변경 불가, 비순차적인 데이터 추가 또는 삭제에 시간이 많이 걸림
    - LinkedList 
        - 불연속적으로 존재하는 데이터를 서로 연결한 형태로 구성
        - 각 요소들은 자신과 연결된 다음 요소에 대한 참조와 데이터로 구성
    - Double LinkedList
        - 참조 변수를 하나 더 추가하여 다음 요소에 대한 참조와 이전 요소의 참조가 가능하도록 함
        - 각 요소에 대한 접근과 이동이 쉽기 때문에 링크드리스트보다 많이 사용됨
        - LinkedList 클래스는 접근성을 높이기 위해 Double LinkedList로 구현되어 있음
    - Double Circular LinkedList
        - 더블 링크드 리스트의 첫번째 요소와 마지막 요소를 연결시킨 것

- ArrayList와 LinkedList의 성능비교
    1. 순차적으로 추가/삭제하는 경우 : ArrayList > LinkedList
    2. 중간 데이터를 추가/삭제하는 경우 : LinkedList > ArrayList
    3. 접근 시간 : ArrayList > LinkedList  
    
    => 다루고자 하는 데이터의 개수가 변하지 않는 경우라면 ArrayList, 데이터 개수의 변경이 잦다면 LinkedList

<br><br>

## 4.Stack과 Queue
- **스택** : 순차적으로 데이터를 추가하고 삭제하므로 ArrayList와 같은 배열 기반의 컬렉션 클래스
- **큐** : 데이터를 꺼낼 때 항상 첫번째 데이터를 삭제하므로 LinkedList로 구현하는 것이 적합
### Priority Queue
- 저장한 순서에 관계없이 우선순위가 높은 것 부터 꺼내게 된다
- null은 저장할 수 없다
- 저장공간으로 배열을 사용하며, 각 요소를 `힙`이라는 자료구조 형태로 저장
- 힙 : 이진 트리의 한 종류로 가장 큰 값이나 가장 작은 값을 빠르게 찾을 수 있음
- `Queue pq = new PriorityQueue();`

```
cf)
- 정수의 경우 컴파일러가 Integer로 오토박싱 해줌
- Integer와 같은 Number의 자손들은 자체적으로 숫자를 비교하는 방법을 정의하고 있기 때문에 비교 방법을 지정해주지 않아도 됨
```

### Deque (Double-Ended Queue)
- 양쪽 끝에서 추가/삭제 가능
- Deque의 조상은 Queue이며, 구현체로는 ArrayDeque와 LinkedList 등이 있다.
- Deque는 스택과 큐를 하나로 합쳐놓은 것과 같으며, 스택으로 사용할 수도 있고, 큐로 사용할 수도 있다.

<br><br>

## 5. Iterator, ListIterator, Enumeration
### Iterator
- 컬렉션에 저장된 각 요소에 접근하는 기능을 가진 Iterator 인터페이스를 정의하고, Collection 인터페이스에는 Iterator를 반환하는 iterator()를 정의하고 있음
- 재사용이 안되므로 사용할때마다 다시 얻어와야 함
```java
public interface Iterator {
    boolean hasNext();
    Object next();
    void remove();
}

public interface Collection{
    ...
    public Iterator iterator();
    ...
}
```
- iterator()는 Collection 인터페이스에 정의된 메소드이므로, 자손인 List와 Set에도 포함되어 있음
- 컬렉션 클래스에 대해 iterator()를 호출하여 Iterator를 얻은 다음 반복문을 사용해 컬렉션 클래스의 요소들을 읽어올 수 있음
```java
List list = new ArrayList();
Iterator it = list.iterator();
```

```
cf) 참조변수 타입을 List 타입으로 한 이유  
- List에 없고 ArrayList에만 있는 메소드를 사용하는 것이 아니라면, List 타입의 참조변수로 선언하는 것이 좋음   
- List 인터페이스를 구현한 다른 클래스로 바꿔야 하는 경우 참조 변수 타입이 List가 아닌 경우 해당 클래스에 없는 메소드를 사용하고 있을 수도 있어 확인 필요
```

- Map 인터페이스를 구현한 컬렉션 클래스는 iterator() 직접 호출 불가
- keySet()이나 entrySet()과 같은 메소드를 통해서 키와 값을 각각 따로 Set의 형태로 얻어온 후 다시 iterator()를 호출해야 Iterator를 얻을 수 있음
```java
Map map = new HashMap();
...
Iterator it = map.keySet().iterator();
```

### ListIterator와 Enumeration
- Enumeration
    - Iterator의 구버전
- ListIterator
    - Iterator에 양방향 조회 기능 추가(List를 구현한 경우만 사용 가능)
    - 각 요소간의 이동이 자유로움
    - 이동하기 전에 hasNext()나 hasPrevious()를 호출해서 이동 가능한지 확인해야 함

<br><br>

## 6. Arrays
### 배열의 복사
- copyOf()
    - 배열 전체 복사
- copyOfRange(arr, start, end)
    - 배열의 일부를 복사해서 새로운 배열을 만들어 반환
    - 지정된 범위의 끝은 포함되지 않음

### 배열 채우기
- fill()
    - 배열의 모든 요소를 지정된 값으로 채움
- setAll()
    - 배열을 채우는데 사용할 함수형 인터페이스를 매개변수로 받음
    - 이 메소드를 호출할 때는 함수형 인터페이스를 구현한 객체를 매개변수로 지정하던가 람다식을 지정해야 함

### 배열의 정렬과 검색
- sort()
    - 배열을 정렬할 때
- binarySearch()
    - 배열에 저장된 요소를 검색할 때
    - 배열에 지정된 값이 저장된 위치를 찾아서 반환
    - 배열이 정렬된 상태여야 올바른 결과를 얻음
    - 검색한 값과 일치하는 요소들이 여러개 라면 어떤 것의 위치가 반환될 지 알 수 없음

### 문자열의 비교와 출력 
- equals()
    - 두 배열에 저장된 모든 요소를 비교해 같으면 true, 다르면 false
    - 다차원 배열에서는 `deepToEquals()`
- toString()
    - 일차원 배열에서만 사용 가능
    - 다차원 배열에서는 `deepToString()`
    - deepToString() : 배열의 모든 요소를 재귀적으로 접근해서 문자열 구성

### 배열을 List로 변환 - asList(Object... a)
- asList()
    - 배열을 List에 담아서 반환
    - 매개변수 타입이 가변인수라서 배열 생성 없이 저장할 요소들만 나열하는 것도 가능
    ```java
    List list = Arrays.asList(new Integer[] {1,2,3,4,5});
    List list = Arrays.asList(1,2,3,4,5);
    ```
    - asList()가 반환한 List의 크기를 변경할 수 없음

### parallelXXX(), spliterator(), stream()
- parallel
    - 빠른 결과를 얻기 위해 여러 쓰레드가 작업을 나누어 처리하도록 함
- spliterator()
    - 여러 쓰레드가 처리할 수 있도록 하나의 작업을 여러 작업으로 나누는 Spliterator 반환
- stream()
    - 컬렉션을 스트림을 변환

<br><br>

## 7. Comparator와 Comparable
- 두가지 모두 인터페이스로 컬렉션을 정렬하는데 필요한 메소드를 정의하고 있음
- Comparable을 구현하고 있는 클래스들은 같은 타입의 인스턴스끼리 서로 비교할 수 있는 클래스들임  
  (Wrapper 클래스, String, Date, File 등)
```java
public interface Comparator {
    int compare(Object o1, Object o2);
    boolean equals (Object obj);
}

public interface Comparable {
    public int compareTo(Object o);
}
```
- Comparable : 기본 정렬 기준을 구현하는 데 사용
- Comparator : 기본 정렬 기준 외에 다른 기준으로 정렬하고자 할 때 사용

- compareTo()
    - 비교하는 두 객체가 같으면 0
    - 비고하는 값보다 작으면 음수, 크면 양수
- equals()는 모든 클래스가 가지고 있는 공통 메소드이지만, Comparator를 구현하는 클래스는 오버라이딩이 필요할 수도 있다는 것을 알리기 위해 정의한 것

```java
class Descending iplements Comparator {
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Comparable && o2 instanceof Comparable) {
            Comparable c1 = (Comparable) o1;
            Comparable c2 = (Comparable) o2;
            return c1.compareTo(c2) * -1;
            // return c2.compareTo(c1)
        }
        return -1
    }
}
```
### 사용 예
- Arrays.sort()
    - 배열을 정렬할 때, Comparator를 지정해주지 않으면, 저장하는 객체에 구현된 내용에 따라 정렬됨
    ```java
    static void sort(Object[] a)   // Comparable에 의한 정렬
    static void sort(Object[] a, Comparator c)  // 지정한 Comparator에 의한 정렬
    ```
- String
    - Comparable 구현은 문자열이 사전순으로 정렬되도록 작성 (유니코드 오름차순)
    - 대소문자 구분하지 않고 비교하는 Comparator를 상수 형태로 제공
      Arrays.sort(strArr, String.CASE_INTENSITIVE_ORDER);
    - 내림차순 : compareTo() * -1 || c2.compareTo(c1)
    - compare()의 매개변수가 Object 타입이기 때문에 compareTo()를 바로 호출할 수 없으므로 먼저 Comparable로 형변환해야 한다.

<br><br>

## 8. HashSet
- Set 인터페이스를 구현한 컬렉션으로 중복된 요소를 저장하지 않음
- 컬렉션 내의 중복 요소들을 쉽게 제거 가능
- 저장 순서를 유지하고자 할 때는 `LinkedHashSet`
- 정렬하기 위해서는 `Collections` 클래스의 `sort()`를 사용
    - sort() 메소드는 인자로 List 인터페이스 타입을 필요로 하기 때문에 HashSet에 저장된 객체들을 List에 담아서 처리해야 함
- 인스턴스를 같은 것으로 인식하게 하고자 하는 경우
    - HashSet의 add()는 새로운 요소를 추가하기 전에 기존에 저장된 요소와 같은 것인지 판별하기 위해 추가하려는 요소의 equals()와 hashCode()를 호출함
    - 따라서 equals()와 hashCode()를 목적에 맞게 오버라이딩 해야 함
    - hashCode()
        ```java
        public int hashCode(){
            return Object.hash(name, age);
        }
        ```
- 합잡합(addAll), 교집합(retainAll), 차집합(removeAll)

<br><br>

## 9. TreeSet
- 이진 검색 트리 형태로 데이터를 저장하는 컬렉션 클래스
- TreeSet은 이진 검색 트리의 성능을 향상시킨 '레드-블랙 트리'로 구현되어 있음
- 중복된 데이터의 저장을 허용하지 않으며 저장 순서를 유지하지 않는다.
- 이진 검색 트리
    - 부모 노드의 왼쪽에는 부모 노드의 값보다 작은 값의 자식 노드를, 오른쪽에는 큰 값의 자식 노드를 저장하는 이진트리
    - TreeSet에 저장되는 객체가 Comparable을 구현하던가, Comparator를 제공해서 두 객체를 비교할 방법을 알려주지 않으면
      TreeSet에 객체를 저장할때 예외 발생
    - 중복된 값 저장 불가
- 트리는 데이터를 순차적으로 저장하는 것이 아니라 저장위치를 찾아서 저장해야 하고,
  삭제하는 경우 트리의 일부를 재구성해야 하므로 ㅇ링크드 리스트보다 데이터의 추가/삭제 시간은 더 걸린다.
- 대신 검색과 정렬기능이 더 뛰어나다.
- headSet(), tailSet()을 사용하면, TreeSet에 저장된 객체 중 지정된 기준 값보다 큰 값의 객체들과 작은 값의 객체들을 얻을 수 있음

<br><br>

## 10. HashMap과 HashTable
- HashTable보다 새로운 버전인 HashMap 사용 권장
- Map을 구현했으므로 key, value를 묶어 하나의 entry로 저장
- hashing을 사용하기 때문에 많은 양의 데이터를 검색하는 데 뛰어난 성능
- 데이터 저장 방법
    - Entry라는 내부 클래스를 정의하고 다시 Entry 타입의 배열을 선언함
    - 키와 값은 서로 관련된 값이기 때문에 하나의 클래스로 정의해서 하나의 배열로 다루는 것이 데이터 무결성 측면에서 바람직
    ``` java
    Entry[] table;
    class Entry{
        Object key;
        Object value;
    }
    ```
- HashMap은 키와 값을 Object 타입으로 저장하고 있어 어떠한 객체도 저장할 수 있음
- Map은 값은 중복을 허용하지만 키는 중복을 허용하지 않기 때문에 저장하려는 두 데이터 중 어느 쪽을 키로 할 것인지 결정해야 함
- 키가 이미 있는 경우 값은 덮어씌워짐
- HashMap은 null을 허용해기 때문에 `map.put(null, null);`, `map.get(null);`이 가능

### 해싱과 해시함수
- 해시 함수를 이용해서 데이터를 해시 테이블에 저장하고 검색하는 기법
- 해시 함수는 데이터가 저장되어 있는 곳을 알려 주기 때문에 다량의 데이터 중에서 원하는 데이터를 빠르게 찾을 수 있다.
- 해싱에서 사용하는 자료구조는 **배열과 링크드 리스트의 조합**으로 되어 있다.
    - 저장할 데이터의 키를 해시 함수에 넣으면 배열의 한 요소를 얻게 되고, 다시 그 곳에 연결되어 있는 링크드 리스트에 저장한다.
    - 배열의 각 요소에는 링크드 리스트가 저장되어 있어 실제 데이터는 링크드 리스트에 담겨지게 된다.
- 해시를 이용해 데이터를 검색하는 과정
    1. 검색하고자 하는 값의 키로 해시 함수 호출
    2. 해시 함수의 계산 결과(해시 코드)로 해당 값이 저장되어 있는 링크드 리스트를 찾는다.
    3. 링크드 리스트에서 검색한 키와 일치하는 데이터를 찾는다.
- 링크드 리스트는 검색에 불리한 자료구조 이므로, 많은 배열에 하나의 데이터만 저장되어 있는 형태가 더 빠른 검색 결과를 얻을 수 있다.
    - 하나의 링크드 리스트에 최소한의 데이터만 저장되려면, 저장될 데이터의 크기를 고려해서 HashMap의 크기를 적절하게 지정해 주어야 하고,
      해시 함수가 서로 다른 키에 대해 중복된 해시 코드의 반환을 최소화 해야 한다.

<br><br>

## 11. TreeMap
- 이진 검색 트리의 형태로 키와 값의 쌍으로 이루어진 데이터를 저장  
  => 검색과 정렬에 적합한 클래스
- 검색에 관한 대부분의 경우에서 HashMap이 뛰어나고, 범위 검색이나 정렬이 필요한 경우에는 TreeMap

#
[출처] : Java의 정석 3rd Edition