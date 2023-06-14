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