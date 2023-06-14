package JavaIO.io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ObjectOutputExam2 {
    public static void main(String[] args) throws Exception{
        User user1 = new User("hong@exam.com", "홍길동", 1992);
        User user2 = new User("go@exam.com", "고길동", 1995);
        User user3 = new User("d@exam.com", "둘리", 1991);
        // /tmp/user.dat
        // ArrayList 도 직렬화가 가능하다.
        ArrayList<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/tmp/userlist.dat"));
        out.writeObject(list);
        out.close();
    }
}