## ****Object의 오버라이딩 하라고 제공하는 toString(), equals(), hashCode() 메소드 사용방법****

### Object가 오버라이딩하라고 제공하는 메소드

- toString()
- equals() & hashCode()

equals : 객체간의 값이 같은 값이냐?

hashCode : 컬렉션 프레임워크에서 쓰임

```java
package 객체지향문법_2;

public class Car {
    public void run() {
        System.out.println("전륜구동으로 달린다.");
    }

    // Car를 출력하고 싶다면.

    @Override
    public String toString() {
        return "자동차!!!";
    }
}
```

```java
package 객체지향문법_2;

public class CarExam02 {
    public static void main(String[] args) {
        Car c1 = new Car();
        System.out.println(c1); // println(Object x);
    }
}

// 부모타입의 변수로 자식인스턴스를 참조할 수 있다.
// 조상타입의 변수로 후손인스턴스를 참조할 수 있다.
// Car c1 = nwe Bus();
// Car c2 = new 이층버스(); // 이층버스는 Car의 자손이다.
// Object o1 = new Car();
// Object o2 = new Bus();
// Object o3 = new 이층버스();
// System.out.println(o1.toString()); == System.out.println(o1);
```