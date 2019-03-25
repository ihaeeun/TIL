## Collections Framework
**컬렉션 프레임워크**  
* 데이터 군을 저장하는 클래스들을 표준화한 설계   
* 필요한 기능을 가진 3개의 인터페이스로 정의.
    > List  
    > Set  
    > Map  
* List와 Set을 구현한 컬렉션 클래스들은 서로 많은 공통부분이 있어 Collection 인터페이스에서 상속받음
* **Collection 인터페이스**  
: List와 Set의 조상으로 컬렉션 클래스에 저장된 데이터를 읽고, 추가하고 삭제하는 등 컬렉션을 다루는 가장 기본적인 메소드가 정의되어 있다.

| 인터페이스 | 특징 | 구현클래스  
| :-----: | :----- | :----- | 
|List| 순서가 있는 데이터의 집합. 데이터 중복 허용. | ArrayList, LinkedList, Stack, Vector 등
|Set| 순서를 유지하지 않는 데이터 집합. 데이터 중복 불허. | HashSet, TreeSet 등
|Map| 키(key)와 값(value)의 쌍(pair)으로 이루어진 데이터 집합. 순서는 유지되지 않으며, 키는 중복을 허용하지 않고, 값은 중복을 허용 | HashMap, TreeMap, Hashtable, Properties 등


### ArrayList
#
* Object 배열을 이용해 데이터를 순차적으로 저장  
* 배열에 더 이상 저장할 공간이 없으면 보다 큰 새로운 배열을 생성해서 기존 배열에 저장된 내용을 새로운 배열로 복사한 뒤 저장된다.

