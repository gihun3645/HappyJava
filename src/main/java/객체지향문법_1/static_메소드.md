## static 메소드(클래스 메소드)

### static한 메소드는 인스턴스를 생성하지 않아도 호출할 수 있다.

```java
VendingMachine.printVersion();
```

- 위의 코드가 오류가 발생하지 않는다면, printVersion() 메소드는 static한 메소드이다.
- static한 메소드는 인스턴스 생성 없이 실행가능하다.

```java
package 객체지향문법_1;

public class VendingMachine {
    // field (가지는 것들)

    // 생성자
    // method
    public String pushProductButton(int menuId) {
        System.out.println(menuId+"를 전달받았습니다.");
        return "콜라";
    }

    public static void printVersion() {
        System.out.println("v1.0");
    }
}
```

```java
package 객체지향문법_1;

public class VendingMachineMain {
    public static void main(String[] args) {
        // static 한 메소드는 클래스명 다음에 사용한다. (규칙)
        VendingMachine.printVersion();
        VendingMachine vm1 = new VendingMachine(); // 자판기만 메모리에 생성

        // 리턴된 "콜라"는 product 변수가 참조하게 됨
        String product = vm1.pushProductButton(100);

        // 인스턴스를 참조해서도 가능은 하지만 권장하지 않음
        vm1.printVersion();
        System.out.println(product);

    }
}
```