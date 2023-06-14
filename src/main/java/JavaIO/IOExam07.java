package JavaIO;

import java.io.StringReader;

public class IOExam07 {
    public static void main(String[] args) throws Exception{
        StringReader in = new StringReader("helloworld!!!");
        int ch = -1;

        while ((ch=in.read()) != -1) {
            // 형변환을 해줘야함
            System.out.print((char)ch);
        }
        in.close();
    }
}