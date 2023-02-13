## 조건문 switch

### switch

- switch는 제어문(control flow statments) 중에 하나이다. switch문은 경우에 따라 if문보다 가독성이 좋을 수 있다.
- 이론적으로는 switch문이 if문보다 속도가 빠르다고 하지만 의미가 없는 수준이다.

### switch 사용법

- switch 블록 안에는 여러개의 case가 올 수 있다.
- switch 블록 안에는 하나의 default가 올 수 있다
- break문은 생략할 수 있다.

```java
switch (변수) {
	case 값1:
			변수가 값1일때 실행된다.
			break;
	case 값2:
			변수가 값2일 때 실행된다.
			break;
	...
	defualt:
			변수의 값이 어떤 case애도 해당하지 않을 경우 실행된다.
}
```

### 예제1

- num의 값을 1,2,3,4 로 바꿔가면서 실행해보자

```java
package 자바_기본_문법;

public class SwitchExam1 {
    public static void main(String[] args) {
        int num = 1;
        switch (num) {
            case 1:
                System.out.println("1입니다.");
            case 2:
                System.out.println("2입니다.");
            case 3:
                System.out.println("3입니다.");
        }
    }
}
```

### 예제2

- num의 값을 1,2,3,4로 바꿔가면서 실행한다.

```java
package 자바_기본_문법;

public class SwitchExam2 {
    public static void main(String[] args) {
        int num = 1;
        switch (num) {
            case 1 :
                System.out.println("1입니다.");
                break;
            case 2 :
                System.out.println("2입니다.");
                break;
            case 3 :
                System.out.println("3입니다.");
                break;
            default :
                System.out.println("1,2,3이 아닙니다.");
        }
    }
}
```

### 예제3

- 변수 ch의 값을 ‘a’, ‘b’, ‘c’, ‘d’, ‘A’, ‘B’, ‘C’, ‘D’ 로 바꿔가면서 실행한다.

```java
package 자바_기본_문법;

public class SwitchExam3 {
    public static void main(String[] args) {
        char ch = 'a';
        switch(ch) {
            case 'a' :
            case 'A' :
                System.out.println("A입니다.");
                break;
            case 'B':
            case 'b':
                System.out.println("B입니다.");
                break;
            case 'c':
            case 'C':
                System.out.println("C입니다.");
                break;
            default:
                System.out.println("A,B,C가 아닙니다.");
        }
    }
}
```

### 예제 4

- str의 값을 “감자”, “고구마”, “사과”로 변경하며 실행한다.
- JDK 7이상에서만 switch에서 string타입을 사용할 수 있다.

```java
package 자바_기본_문법;

public class SwitchExam4 {
    public static void main(String[] args) {
        String str = "감자";
        switch (str) {
            case "감자":
                System.out.println("감자입니다.");
                break;
            case "고구마:":
                System.out.println("고구마입니다.");
                break;
            default:
                System.out.println("감자와 고구마가 아닙니다.");
        }
    }
}
```

### 찾아보기

- JDK 14, JDK 17에서 switch와 관련된 새로운 문법이 추가되었다. 어떤 내용이 추가되었는가?