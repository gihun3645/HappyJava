package JavaIO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IOExam01 {
    public static void main(String[] args) throws Exception{
        // 키보드로부터 한줄씩 입력받는다.
        // BufferedReader의 readLine()을 이용해야 한줄씩 입력받을 수 있다.
        // BufferdReader는 장식역활을 수행한다.

        // 키보드를 나타내는 것은 System.in - 주인공 - inputStream

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        System.out.println(line);
        br.close();
    }
}