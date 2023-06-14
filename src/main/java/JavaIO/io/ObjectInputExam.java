package JavaIO.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectInputExam {
    public static void main(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("/tmp/user.dat"));
        // user 객체를 형변환 하여 받아들임
        User user = (User)in.readObject();
        in.close();
        System.out.println(user);
    }
}
