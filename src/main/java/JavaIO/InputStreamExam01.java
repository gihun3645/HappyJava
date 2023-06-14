package JavaIO;

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