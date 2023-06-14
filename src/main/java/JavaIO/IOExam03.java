package JavaIO;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class IOExam03 {
    public static void main(String[] args) throws Exception {
        // 문제. 이름, 국어, 영어, 수하, 총점, 평균 점수를 /tmp/score.dat 파일에서 읽어들이시오.
        DataInputStream in = new DataInputStream(new FileInputStream("/tmp/score.dat"));

        // 2 사람의 정보를 읽어옴
        printStudent(in);
        printStudent(in);

        in.close();
    }

    private static void printStudent(DataInputStream in) throws IOException {
        String name = in.readUTF();
        int kor = in.readInt();
        int eng = in.readInt();
        int math = in.readInt();
        double total = in.readDouble();
        double avg = in.readDouble();

        System.out.println(name);
        System.out.println(kor);
        System.out.println(eng);
        System.out.println(math);
        System.out.println(total);
        System.out.println(avg);
    }
}