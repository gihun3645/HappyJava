## 반복문 do while

### do / while 사용법

- do/while 문은 `탈출 조건식` 이 false를 반환할 때 do / while 문을 종료하게 된다.

```java
변수의 초기롸 
do {
		탈출 조건식이 참일 경우 실행되는 코드;
		변수의 증감식;
} while (탈출 조건식);
```

### 예제 1

- 1부터 10까지 정수를 출력한다.

```java
package 자바_기본_문법;

public class DoWhileExam1 {
    public static void main(String[] args) {
        int i = 1;
        do {
            System.out.println(i);
            i++;
        } while (i <= 10);
    }
}
```

### 예제 2

- do / while 문장은 무조건 한번은 실행된다.

```java
package 자바_기본_문법;

public class DoWhileExam2 {
    public static void main(String[] args) {
        int i = 1;
        do {
            System.out.println(i);
            i++;
        } while (i < 1);
    }
}
```