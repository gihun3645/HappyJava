package JavaIO;

import java.io.ByteArrayOutputStream;

public class IOExam04 {
    public static void main(String[] args) throws Exception{
        int data1 = 1;
        int data2 = 2;
        // ByteArrayOutputStream 은 생성자에 아무것도 들어가지 않는다.
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.write(data1); // data1의 마지막 1byte 저장한다.
        out.write(data2);
        out.close();

        // 꺼낼 때
        byte[] array = out.toByteArray();
        System.out.println(array.length);
        System.out.println(array[0]);
        System.out.println(array[1]);
    }
}