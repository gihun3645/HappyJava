package JavaIO;

import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileOutputStream;

public class IOExam02 {
    public static void main(String[] args) throws Exception {
        // 문제. 이름, 국어, 영어, 수학 점수를 /tmp/score.dat 파일에 저장하시오.
        String name = "kim";
        int kor = 90;
        int eng = 50;
        int math = 70;
        double total = kor+eng+math;
        System.out.println(total);
        double avg = total / 3.0;
        System.out.println(avg);

        DataOutputStream out = new DataOutputStream(new FileOutputStream("/tmp/score.dat"));
        out.writeUTF(name);
        out.writeInt(kor);
        out.writeInt(math);
        out.writeInt(eng);
        out.writeDouble(total);
        out.writeDouble(avg);

        out.writeUTF(name);
        out.writeInt(kor);
        out.writeInt(math);
        out.writeInt(eng);
        out.writeDouble(total);
        out.writeDouble(avg);
        out.close();
    }
}