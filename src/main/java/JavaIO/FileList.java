package JavaIO;

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