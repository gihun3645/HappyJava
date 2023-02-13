## 조건문 if와 삼항연산자

### if 첫번째 사용법

- 중괄호 안의 내용을 블록이라고 한다.

```java
if(조건문) {
	조건문이 참일 경우 실행되는 블록
}
```

### 예제

```java
package 자바_기본_문법;

public class IfExam1 {
    public static void main(String[] args) {
        int a = 5;

        if(a > 4) {
            System.out.println("a는 4보다 큽니다.");
        }
    }
}
```

### if 두번째 사용법

```java
if(조건문) {
	조건문이 참일 경우 실행되는 블록
} else {
	조건문이 거짓일 경우 실행되는 블록
}
```

### 예제 2

- a의 값을 변경하면서 실행한다.

```java
package 자바_기본_문법;

public class IFExam2 {
    public static void main(String[] args) {
        int a = 3;

        if(a>4) {
            System.out.println("a는 4보다 큽니다.");
        } else {
            System.out.println("a는 4이하입니다.");
        }
    }
}
```

### if 세번째 사용법

- else if 는 여러줄 추가될 수 있다.

```java
if(조건문1) {
	조건문1이 참일 경우 실행되는 블록
} else if(조건문2) {
	조건문2가 참일 경우 실행되는 블록
} else {
	조건문1이나 조건문2에 해당되지 않을 경우 실행되는 블록 
}
```

### 예제3

```java
package 자바_기본_문법;

public class IfExam3 {
    public static void main(String[] args) {
        int score = 50;

        if(score >= 90) {
            System.out.println("A");
        } else if(score >= 80) {
            System.out.println("B");
        } else if (score >= 70) {
            System.out.println("C");
        } else if (score >= 60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
        System.out.println("프로그램 종료");
    }
}
```

### if 문장에 중괄호가 없을 경우?

- if문장에 중괄호, 즉 블록이 없을 경우는 if문장 다음 문장만 조건에 만족할 경우 실행된다.
- “hello”는 무조건 출력된다. (들여쓰기를 잘못한 안좋은 코드의 예)

```java
package 자바_기본_문법;

public class IfExam4 {
    public static void main(String[] args) {
        int a = 10;

        if (a > 5)
            System.out.println("a는 10보다 큽니다.");
        System.out.println("hello");
    }
}
```

### 삼항연산자

- 자바에는 항이 3개인 연산자가 하나 있다. 조건식이 참일 경우 반환값 1이 사용되고, 거짓일 경우 반환값2가 사용된다.

`조건식 ? 반환값1 : 반환값2`

### 예 - 삼항연산자

- a의 값을 10, 4 등으로 바꿔가면서 실행해보자

```java
package 자바_기본_문법;

public class IfExam5 {
    public static void main(String[] args) {
        int a = 10;

        int value = (a > 5) ? 20 : 30;

        System.out.println(value);
    }
}
```