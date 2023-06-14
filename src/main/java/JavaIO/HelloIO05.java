package JavaIO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class HelloIO05 {
    public static void main(String[] args) throws Exception {
        // FileOutputStream은 "/tmp/my.txt"에 저장한다
        // FileOutputStream은 write(int); int의 마지마 byte만 저장
        // OutPutStreamWriter 생성자에 들어온 OutputStream의 write()을 이용하여 쓴다.
        // OutPutStreamWriter는 write(int); int의 끝부분 char를 저장
        // PrintWriter는 생성자에 들어온 OutputStreamWrite의 write()을 이용하여 쓴다.
        // PrintWriter는 println(문자열); 문자열을 출력한다.
        PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream("/tmp/my.txt")));
        out.println("hello");
        out.println("world");
        out.println("!!!!!");
        out.close();
    }
}
