## Package 부제 : 1반 영희, 2반 영희

### 패키지

- 클래스는 패키지를 이용하여 관련된 클래스들을 관리한다. 자바에서 패키지는 폴더와 거의 같은 기능을 제공한다고 생각하면 된다.

### 패키지 이름 규칙

- 패키지 이름은 보통 도메인 이름을 거꾸로 적은 후에 프로젝트 이름 등을 붙여서 만들게 된다.

패키지는 아키텍트랑 관련되어 있다.

### 패키지 선언방법

package 패키지명;

- 주석문이나 빈줄을 제외하고 가장 윗 줄에 위와 같은 형식으로 선언한다.

### 패키지 연습하기

- com.example.util 이란 package에 Calculator 클래스를 작성한다.
- 해당 클래스는 int plus(int, int), int minus(int, int) apthemfmf rkwlsek.
- com.example.main 이란 package에 CalculatorTest클래스를 작성한다.
- 해당 클래스는 Calculator클래스 인스턴스를 생성한 후, plus, minus 메소드를 호출한 결과를 출력한다.

```java
package 객체지향문법_2.com.example.util;

public class Calculator {
    public int plus(int x, int y) {
        return x+y;
    }

    public int minus(int x, int y) {
        return x-y;
    }
}
```

```java
package 객체지향문법_2.com.example.main;

import 객체지향문법_2.com.example.util.Calculator;

public class CalculatorMain {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        int value = cal.plus(10, 100);
        System.out.println(value);

        // 같은 이름의 클래스를 사용할 땐, 하나는 import를 해서 사용하고 또 다른 하나는 클래스명 앞에 패키지명까지 붙여서 사용해야함
        객체지향문법_2.com.example.util2.Calculator cal2 = new 객체지향문법_2.com.example.util2.Calculator();
        int value2 = cal2.divine(100, 100);
        System.out.println(value2);
    }
}
```

```java
package 객체지향문법_2.com.example.util2;

public class Calculator {
    public int divine(int x, int y) {
        return x/y;
    }
}
```