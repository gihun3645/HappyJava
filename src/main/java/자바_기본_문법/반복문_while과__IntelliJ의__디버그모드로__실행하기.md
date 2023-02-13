## 반복문 while과 IntelliJ의 디버그모드로 실행하기

### while

- while은 반복문(iterator statements) 중에 하나이다.
- 컴퓨터가 잘하는 일은 반복하면서 일을 처리하는 것이다.

### while 사용법

- while문은 `탈출 조건식` 이 false를 반환할 때 while문을 종료하게 된다.

```java
변수의 초기화
while (탈출 조건식) {
	탈출 조건석이 참일 경우 실행되는 코드;
	변수의 증감식;
}
```

### 예제 1

- 1부터 5까지 출력하시오.

```java
package 자바_기본_문법;

public class WhileExam1 {
    public static void main(String[] args) {
            int i = 1;
            while (i <= 5) {
                System.out.println(i);
                i++;
        }
    }
}
```

### 예제2

- while(true) { …. } 는 무한 루프(loop, 반복문)이라고 한다. 끝없이 반복한다.
- i가 11일 경우 while 블록을 빠져나간다.

```java
package 자바_기본_문법;

public class WhileExam2 {
    public static void main(String[] args) {
        int i = 1;
        while (true) {
            // break 는 반복문을 빠져나감 continue는 '조건문'만 실행시키지 않고 반복문은 이어서 실행 
            if(i == 1) break;
            System.out.println(i);
            i++;
        }
    }
}
```

### while문과 후위 증감식

- 변수 뒤에 후위 증가식이 붙을 경우 변수가 사용된 이후에 값이 증가된다.
- i와 10이 비교를 한 후 i가 증가한다.

```java
package 자바_기본_문법;

public class WhileExam3 {
    public static void main(String[] args) {
        int i = 0;
        while (i++ < 10) {
            System.out.println(i);
        }
    }
}
```

### while문과 continue

- while문에서 continue를 만나면, continue 이하 문장을 실행하지 않고 반복한다.

### 예제 3

- 1부터 10사이에 있는 짝수만 출력하시오.

```java
package 자바_기본_문법;

public class WhileExam4 {
    public static void main(String[] args) {
        int i = 0;
        while (i++ < 10) {
            if(i % 2 != 0)
                continue;
            System.out.println(i);
        }
    }
}
```