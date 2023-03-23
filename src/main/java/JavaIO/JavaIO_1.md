# JAVA IO(입출력)

### IO란?

- Input & Output
- 입출력
- 입력은 키보드, 네트워크, 파일 등으로 부터 받을 수 있다.
- 출력은 화면, 네트워크, 파일 등에 할 수 있다.

### Java IO 도 객체다.

- Java IO에서 사용되는 객체는 자바 세상에서 사용되는 객체이다.
- Java IO가 제공하는 객체는 어떤 대상으로 부터 읽어들이며, 어떤 대상에게 쓰는 일을 한다.

![JavaIO는.png](JavaIO%EB%8A%94.png)

### 주인공과 장식을 구분할 수 있어야 한다.

- 장식은 InputStream, OutputStream, Reader, Write를 생성자에서 받아들인다.
- 주인공은 어떤 대상에게서 읽어들일지, 쓸지를 결정한다.
- 주인공은 1byte or byte[] 단위로 읽고 쓰는 메소드를 가진다.
- 주인공은 1char or char[] 단위로 읽고 쓰는 메소드를 가진다.
- 장식은 다양한 방식으로 읽고 쓰는 메소드를 가진다.

### Java IO의 특수한 객체

System.in   : 표준입력(InputStream)

System.out  : 표준 출력(PrintStream)

System.err : 표준 에러 출력 (PrintStream)

![클래스상속도.jpeg](%ED%81%B4%EB%9E%98%EC%8A%A4%EC%83%81%EC%86%8D%EB%8F%84.jpeg)

InputStream, OutputStream Reader, Writer 가 중요함

![클래스이름이중요1.png](%ED%81%B4%EB%9E%98%EC%8A%A4%EC%9D%B4%EB%A6%84%EC%9D%B4%EC%A4%91%EC%9A%941.png)

![클래스이름이중요1.png](%ED%81%B4%EB%9E%98%EC%8A%A4%EC%9D%B4%EB%A6%84%EC%9D%B4%EC%A4%91%EC%9A%941.png)


### Java IO 클래스는 생성자가 중요하다

- 장식은 `InputStream, OutputStream, Reader, Writer`를 생성자에서 받아들인다. (또한 추상 클래스)
- 생성자에서 `InputStream, OutputStream, Reader, Writer` 를 받아들이면 장식 아니면 주인공

### Java IO를 잘 다루려면, API는 한번쯤은 읽어봐야 한다.

문제) 키보드로 부터 한줄 씩 입력 받아 화면에 한줄씩 출력하시오.

- 어케 해결함?

```java
package javaIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class keyboardIOExam {
    public static void main(String[] args) throws IOException {
        // 키보드로부터 한줄씩 입력받고, 한줄씩 화면에 출력하시오.
        // system.in (InputStream 주인공)
        // 화면에 출력 : System.out (PrintStream 주인공)
        // 키보드로 입력받는다는건 문자를 입력받는 것 : char 단위 입출력
        // char 단위 입출력 클래스는 Reader, Writer
        // 한줄 읽기 BufferedReader 라는 클래스는 readLine이라는 메소드를 가지고 있다.
        //                         더 이상 읽어들일것이(EOF) 없으면 null을 반환
        //                          장식!
        // 한줄 쓰기 : PrintStream, PrintWriter

        // BurredReader x
        // CharReader x - 문자로 부터 입력받음
        // FilterReader x - 장식. Reader 를 넣어줘야 한다.
        // InputStreamReader(InputStream in) - 장식
				// BufferedReader(Reader in) 에서 Reader는 추상클래스임
				// InputStreamreader(InputStream in) 장식
				// Reader의 서브 클래스인 자식들(BufferdReader, InputStreamReader 등)를 받아들이겠다는 말
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

				// System.in 에서 입력받고, InputStreamrader로 전달하고 BuffereReader로 전달하고 문자로 리턴
        String line = null;
        while ((line = br.readLine()) != null) { // 한줄 입력받는다. 
						// Mac의 경우 command + D 를 하면 null값을 넣어줌
						// Windows의 경우 CTRL + D 
            System.out.println("읽어들인값 : "+line);
        }
    }
}
```

![키보드로부터_읽어들이기.png](%ED%82%A4%EB%B3%B4%EB%93%9C%EB%A1%9C%EB%B6%80%ED%84%B0_%EC%9D%BD%EC%96%B4%EB%93%A4%EC%9D%B4%EA%B8%B0.png)