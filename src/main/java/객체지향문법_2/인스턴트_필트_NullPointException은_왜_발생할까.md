## 인스턴스 필드 & NullPointException은 왜 발생할까?

### 클래스 메소드 vs 인스턴스 메소드

- 인스턴스 별로 다르게 동작해야 한다면 인스턴스 메소드
- static 메소드는 객체 생성이나 유틸리티 관련에서 사용될 때가 있다.
- 되도록 인스턴스 메소드를 사용한다.

### 필드(field)

- 클래스가 가지는 속성을 자바 언어에서는 필드라고 말한다.
- 사람에 대한 설계도 즉 클래스가 있다면 그 사람이 가지는 것, 예를 들어 태어난 날짜, 이름 등을 가질 수 있을 것이다. 클래스가 가지는 정보를 필드라고 말한다.
- 다른 언어에서는 멤버변수라고 말하는 경우도 있다.
- 필드는 어떤 키워드와 함께 사용하느냐에 따라서 사용방법이 달라진다.
- static이라는 키워드가 함께 사용되는 필드는 클래스 필드, 함께 사용되지 않는 필드는 인스턴스 필드라고 한다.

### 필드 선언 방법

`[접근제한자] [static] [final] 타입 필드명 [= 초기값];`

- 대괄호 안에 있는 내용은 생략가능하다는 뜻이다.
- 접근제한자는 public, protected, 아무것도 없는 경우(default), private이 올 수 있다.
- 필드명은 식별자 규칙을 따른다. 다만 필드는 첫번째 글자는 소문자로 시작하는 것이 프로그래머 관례이다.
- 타입(type)은 기본형(boolean, type, char, short, int, long, float, double)과 참조 타입(class, 인터페이스, 배열) 등이 나올 수 있다.
- 초기값이 없을 경우에는 참조형일 경우 null로 boolean형일 경우는 false로 나머지 기본형은 모두 0으로 초기화된다.

### 필드 선언 예제

```java
String name;
String address = "경기도 성남시";
pulbic int age = 50;
protected boolean flag;
```

### Person class 작성하기

```java
public class Person {
	String name;
	String address;
	boolean isVip;
}
```

```java
package 객체지향문법_2;

public class PersonTest {
    public static void main(String[] args) {
//        Person p1; // p1은 null 이다.

        Person p1 = new Person();
        Person p2 = new Person();

        p1.name = "홍길동"; // 문자열은 new를 사용하지 않고 인스턴스를 사용할 수 있다. 되도록 new를 사용하지 말자(String 사용할땐)
        p1.address = "일산";
        p1.isVip = true;

        p2.name = "죠죠";
        p2.address = "서울";
        p2.isVip = true;

        System.out.println(p1.address);
        System.out.println(p1.name.length());
        System.out.println(p1.name);
        // System.out.println(p1.address.length()); // NullPointException
        // 아무것도 참조하지 않음
        System.out.println(p1.isVip);
        System.out.println("----------------------------");
        System.out.println(p2.address);
        System.out.println(p2.name);
        System.out.println(p2.name.length());
        System.out.println(p2.isVip);
    }
}
```