## Math 클래스 만들기, 클래스 메소드 만들기, private 생성자

```java
package 객체지향문법_1;

public class MathTest {
    public static void main(String[] args) {
        int value = Math.abs(-5);
        System.out.println(value);

        // 안됨
        // Math m = new Math();

        // Math 클래스를 만든 사람은 여러 개 인스턴스를 생성하지 못하게하므로써
        // 메모리를 절약할 수 있도록 하고 Math.메소드() 형식으로 쉽게 호출하도록 만들었다.
        // (인스턴스를 생성하지 못하도록 생성자를 private하게 만들었다.)
    }
}
```

### Math 클래스 비슷하게 구현하기

```java
package 객체지향문법_1;

public class MyMath {
    // 자동생성 - 기본생성자는 생성자가 없을 경우 컴파일할 때 자동으로 생성한다.
    private MyMath() {}
    // 생성자의 접근 제한자가 private 하다는 것은 인스턴스를 생성을 못하게 한다는 의미
    public static int abs(int x) {
        if(x < 0)
            return x * -1;
        else
            return x;
    }
}
```

```java
package 객체지향문법_1;

public class MyMathTest {
    public static void main(String[] args) {
        int value = MyMath.abs(-5);
        System.out.println(value);

//        MyMath m = new MyMath();
    }
}
```