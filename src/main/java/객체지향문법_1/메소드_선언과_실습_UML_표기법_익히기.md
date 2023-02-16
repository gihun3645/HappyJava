## 메소드 선언 방법과 실습 UML 표기법 익히기

![매개변수1.png](%EB%A7%A4%EA%B0%9C%EB%B3%80%EC%88%981.png)

- 매개변수도 받지 않고, 리턴도 안하는 메소드 정의
- void는 리턴하지 않는다는 의미이고, 괄호 안에 아무 것도 없으면 매개변수를 받지 않는다는 의미이다.

![매개변수2.png](%EB%A7%A4%EA%B0%9C%EB%B3%80%EC%88%982.png)

- 메소드에 들어가는 값은 매개 변수, 메소드에서 나오는 것은 리턴(return)한다라고 표현한다.

![매개변수3.png](%EB%A7%A4%EA%B0%9C%EB%B3%80%EC%88%983.png)

![매개변수4.png](%EB%A7%A4%EA%B0%9C%EB%B3%80%EC%88%984.png)

![매개변수5.png](%EB%A7%A4%EA%B0%9C%EB%B3%80%EC%88%985.png)

메소드는 0개 이상의 매개변수를 받아 들인 후, 코드를 실행하고 어떤 결과를 return 할 수 있다.

![MathBean_클래스_정의.png](MathBean_%ED%81%B4%EB%9E%98%EC%8A%A4_%EC%A0%95%EC%9D%98.png)

```java
package 객체지향문법_1;

public class MathBean {
    // 매개변수도 없도 리턴 타입도 없음
    public void printClassName() {
        System.out.println("MathBean");
    }

    // 매개변수는 있고 리턴타입은 있음
    public void printNumber(int number) {
        System.out.println(number);
    }

    // 매개변수는 없고 리턴타입 있음
    public int getOne() {
        return 1;
    }

    // 매개변수 있고 리턴타입 있음
    public int plus(int x, int y) {
        return x+y;
    }
}
```

![UML표기법.png](UML%ED%91%9C%EA%B8%B0%EB%B2%95.png)

- 프로그래밍을 작성하기 전에 그림으로 어떤 클래스 이름을 사용할지, 어떤 메소드를 만들어야 할지 표현하는 습관을 가지는 것이 좋다.

```java
package 객체지향문법_1;

public class MathBeanTest {
    // MathBean 클래스를 사용하려면 메모리에 올려야함
    // 메모리에 올리려면 new 연산자가 필요하다.
    public static void main(String[] args) {
        // static이 붙은 메소드는 메모리에 올리지 않아도 실행가능

        // MathBean()은 생성
        // MathBean 인스턴스가 만들어지고, Heap이라는 메모리에 올라감
        MathBean math = new MathBean(); // 인스턴스를 참조변수 math가 가리킴

        math.printClassName(); // MathBean
        math.printNumber(5000); // 5000
        int x = math.getOne();
        System.out.println(x); // 1
        int value = math.plus(200, 300);
        System.out.println(value); // 500
    }
}
```