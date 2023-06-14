package JavaIO;

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