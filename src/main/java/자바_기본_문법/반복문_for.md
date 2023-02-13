## 반복문 for

### for

- for문은 반복문(iteration statement) 중에 하나이다.
- while문은 변수 선언, 탈출 조건식, 증감식이 3줄로 이뤄지지만, for문은 한 줄에 모두 표현한다.

### for 사용법

```java
for (변수의 초기화; 탈출조건식; 증감식) {
	탈출 조건식이 참인 경우 실행되는 부분;
}
```

### 예제 1

- “*”를 10번 출력한다.

```java
package 자바_기본_문법;

public class ForExam1 {
    public static void main(String[] args) {
        for(int i=0; i<10; i++) {
            System.out.println("*");
        }
    }
}
```

### 예제2

- 1부터 10까지 출력한다.

```java
package 자바_기본_문법;

public class ForExam2 {
    public static void main(String[] args) {
        for(int i=1; i<=10; i++) {
            System.out.println(i);
        }
    }
}
```

### 중첩 반복문

- 반복문 안에 조건문이 올 수 있는 것처럼, 반복문 안에 반복문이 올 수 있다.

### 중첩 반복문을 이용한 구구단 출력 1/4

- 문자열과 더해지면 문자열이 된다.
- 문자열 + 정수
    - “hello” + 1 ——> “hello1”
- 문자열 + 불린
    - “hello” + “true” ——> “hellotrue”
- 문자열 + 실수
    - “hello” + 50.4 ——> “hello50.4”

### 중첩 반복문을 이용한 구구단 출력 2/4

```java
package 자바_기본_문법;

public class StringExam {
    public static void main(String[] args) {
        String str1 = "hello" + 1;
        String str2 = "hello" + true;
        String str3 = "hello" + 50.4;

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
    }
}
```

### 중첩 반복문을 이용한 구구단 출력 3/4

```java
package 자바_기본_문법;

public class Gugudan1 {
    public static void main(String[] args) {
        for(int i=1; i<=9; i++) {
            System.out.println("1 * "+i+" = "+(i*1));
        }
    }
}
```

### 중첩 반복문을 이용한 구구단 출력 4/4

```java
package 자바_기본_문법;

public class Gugudan2 {
    public static void main(String[] args) {
        for(int k=1; k<=9; k++) {
            for(int i=1; i<=9; i++) {
                System.out.println(k+" * "+i+" = "+(k*i));
            }
            System.out.println();
        }
    }
}
```