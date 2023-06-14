package JavaIO.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ObjectInputExam2 {
    public static void main(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("/tmp/userlist.dat"));
        // user 객체를 형변환 하여 받아들임
        ArrayList<User> list = (ArrayList)in.readObject();
        in.close();
        // 직렬화
        for (int i =0; i < list.size(); i++)
            System.out.println(list.get(i));
    }
}
