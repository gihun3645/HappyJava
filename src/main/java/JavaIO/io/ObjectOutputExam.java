package JavaIO.io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputExam {
    public static void main(String[] args) throws Exception{
        User user = new User("hong@exam.com", "홍길동", 1992);
        // /tmp/user.dat
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/tmp/user.dat"));
        out.writeObject(user);
        out.close();
    }
}