package JavaIO;

// 패키지에 있는 클래스를 사용한다.
import java.io.File;
import java.io.IOException;

// java FileInfo
public class FileInfo {

    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("사용법 : java FileInfo.java 파일이름");
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