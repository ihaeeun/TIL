<!-- ## 1. 자바 (Java Programming Language) -->
## Java의 특징
1. 운영체제에 독립적이다.
    > 자바 응용프로그램은 하드웨어가 아닌 **JVM**하고만 통신하고 JVM이 자바 응용프로그램으로부터 전달받은 명령을 해당 운영체제가 이해할 수 있도록 변환하여 전달한다.  
    **_자바로 작성된 프로그램은 운영체제에 독립적이지만 JVM은 운영체제에 종속적이다._**
2. 객체지향언어이다.
    > 객체지향의 특징 : **상속, 캡슐화, 다형성**
3. 비교적 배우기 쉽다.
4. 자동 메모리 관리 (Grabage Collection)
    > **Garbage Collector**가 자동으로 메모리 관리하여 사용하지 않는 메모리를 체크하고 반한한다.
5. 네트워크와 분산처리를 지원한다.
6. 멀티쓰레드를 지원한다.
    > 자바의 **멀티쓰레드** 프로그램은 OS와 관계없이 구현 가능하며 여러 쓰레드에 대한 스케줄링을 자바 인터프리터가 담당한다.
7. 동적 로딩을 지원한다.
    > 실행 시에 모든 클래스가 로딩되지 않고 필요한 시점에 클래스를 로딩하여 사용할 수 있다. 


## JVM(Java Virtual Machine)
<br>  


## .java 파일 실행
> 1. 자바컴파일러(javac.exe)로 소스파일(.java)로부터 클래스파일(.class) 생성
> 2. 자바 인터프리터(java.exe)로 실행

<br>


## public static void main(String[] args)
main 메소드의 선언부로, 프로그램 실행 시에 'java.exe'에 의해 호출될 수 있도록 미리 약속된 부분
```java
class 클래스이름 {
    public static void main(String[] args) {    //main 메소드 선언부
        //실행될 코드
    }
}
```

<br><br><br>
#
[출처] : Java의 정석 3rd Edition