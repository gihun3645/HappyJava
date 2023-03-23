### File 클래스

- java.io.File 클래스는 파일의 크기, 파일의 접근 권한, 파일의 삭제, 이름 변경 등의 작업을 할 수 있는 기능을 제공하여 준다.
- 여기서 주의해야 할 것은 디렉토리(폴더) 역시 파일로써 취급된다는 것이다.

![File클래스생성사.png](File%ED%81%B4%EB%9E%98%EC%8A%A4%EC%83%9D%EC%84%B1%EC%82%AC.png)![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/815233ea-7a12-44cc-b294-afb341219b27/Untitled.png)

![File클래스중요메소드.png](File%ED%81%B4%EB%9E%98%EC%8A%A4%EC%A4%91%EC%9A%94%EB%A9%94%EC%86%8C%EB%93%9C.png)![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/77b0aaf7-11d3-4159-90fd-6b3a4de75744/Untitled.png)

### 예제

```java
package javaIO;

// 패키지에 있는 클래스를 사용한다.
import java.io.File;
import java.io.IOException;

// java FileInfo
public class FileInfo {

    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("사용법 : java FileInfo 파일이름");
            System.exit(0); // return; 같은말 
        } // if end

				// 문자를 하나 받아들임
        File f = new File(args[0]);
        if(f.exists()) { // 파일이 존재할 경우
            System.out.println("length : "+f.length());
            System.out.println("canRead : "+f.canRead());
            System.out.println("canWrite : "+f.canWrite());
            System.out.println("getAbsolutePath : "+f.getAbsolutePath());
            try {
                System.out.println("getCanonicalPath :"+f.getCanonicalPath());
            } catch (IOException e) {
                System.out.println(e);
            }
            System.out.println("getName : "+f.getName());
            System.out.println("getParent : "+f.getParent());
            System.out.println("getPath : "+f.getPath());
        } else { // 파일이 존재하지 않을 경우
            System.out.println("파일이 존재하지 않습니다.");
        }
    } // main end 
}
```

### 파일목록

```java
package javaIO;

import java.io.File;

// 파일 목록 출력하기
public class FileList {
    public static void main(String[] args) {
        File file = new File("/tmp");

        printFiles(file);
    }

    private static void printFiles(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            file.listFiles();
            // 파일 이름 출력
            for (int i = 0; i < files.length; i++) {
                System.out.println("[dir] - "+files[i]);
                printFiles(files[i]);
            }
        } else if(file.isFile()){
            System.out.println(file.getName());
        } else {
            System.out.println("else --"+file.getName());
        }
    }
}
```

### 파일삭제

```java
import java.io.*;

public class FileDelete {
	public static void main(String[] args) {
			if(args.length != 1) {
				System.out.println("사용법 : java FileDelete 파일이름");
				System.exit(0);
			} // if end

				File f = new File(args[0]);
				if(f.exists()) {
					boolean deleteflag = f.delete();
					if(deleteflag)
						System.out.println("파일삭제를 성공하였습니다.");
					else
						System.out.println("파일 삭제를 실패하였습니다.");
			}
		}
}
```

### 임시파일 생성과 삭제

```java
package javaIO;

import java.io.File;
import java.io.IOException;

public class TempFile {
    public static void main(String[] args) {
        try {
            File f = File.createTempFile("tmp_", ".dat");
            System.out.println(f.getAbsolutePath());
            System.out.println("10초 동안 멈춰있습니다.");
            try {
                Thread.sleep(10000); // 10초 동안 정지
            } catch(InterruptedException e1) {
                System.out.println(e1);
            }
            f.deleteOnExit(); // JVM이 종료될 때 자동으로 파일을 삭제한다.
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
```

![바이트스트림.png](%EB%B0%94%EC%9D%B4%ED%8A%B8%EC%8A%A4%ED%8A%B8%EB%A6%BC.png)85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2023-01-26_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_11.29.03.png)

- 주인공과 장식을 구분 할 수 있어야 한다.

![InputStream이가지는주요메소드.png](InputStream%EC%9D%B4%EA%B0%80%EC%A7%80%EB%8A%94%EC%A3%BC%EC%9A%94%EB%A9%94%EC%86%8C%EB%93%9C.png)![스크린샷 2023-03-23 오후 11
### InputStream, OutpuSteam

- 추상 클래스
- byte 단위 입출력 클래스는 InputStream, OutputStream의 후손이다.

```java
package javaIO;

import java.io.IOException;
import java.io.InputStream;

/*
1byte가 표현할 수 있는 값 : 00000000 ~ 11111111
read() 메소드가 읽어들일 수 있는 정보.
1byte씩 파일을 읽어들인다. 파일의 크기를 모른다. 그럼 언제까지 읽어들이냐
더 이상 읽어들일게 없다 EOF (EOF를 표현할 수 없어서, int 타입을 리턴)

int 에 1 byte 값을 담자 00000000 00000000 00000000 00000000
                     00000000 00000000 00000000 11111111
EOF : -1
1 --> 00000000 00000000 00000000 00000001
1의 보수 11111111 11111111 11111111 11111110
2의 보수 11111111 11111111 11111111 11111111 : -1
 */

/* 숙제?

1. txt 파일로 입력 받아 한줄씩 입력 받아 파일에 출력한다.
2. 키보드로 부터 한줄씩 입력받아 파일에 출력한다. (파일명은 아규먼트로 받아들인다)
3. txt 파일로 부터 한줄씩 입력받아 다른 파일에 한줄씩 출력한다.
 */
public class InputStreamExam01 {
    public static void main(String[] args) {

        InputStream in = null;
        try {
            int data = in.read();
            // byte를 리턴하지 못하고 int로 리턴하는 이유
            // : EOF를 표현할 방법이 없어서
        } catch (IOException ex) {
            System.out.println("IO 오류" + ex);
        } finally {
            try {
                in.close();
            } catch (Exception ex2) {
                System.out.println("io 오류 : " + ex2);
            }
        }
    }
}
```