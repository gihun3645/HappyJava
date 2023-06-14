package JavaIO;


import java.io.File;

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