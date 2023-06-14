package JavaIO.io;

import java.io.*;
import java.util.ArrayList;

public class ObjectInputOutputExam {
    public static void main(String[] args) throws Exception {
        User user1 = new User("hong@exam.com", "홍길동", 1992);
        User user2 = new User("go@exam.com", "고길동", 1995);
        User user3 = new User("d@exam.com", "둘리", 1991);
        ArrayList<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);


//        // User 자체가 복사가 되지 않은 얕은 복사
//        ArrayList<User> list2 = list;
//
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list2.get(i));
////            list2.add(list.get(i));
//        }
//
//        list.remove(2);
//        System.out.println(list.size()); // 2
//        System.out.println(list2.size()); // 2


        // 깊은 복사를 하기 위해서 객체 직렬화가 필요함
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bout);
        out.writeObject(list);
        out.close();
        bout.close();

        byte[] array = bout.toByteArray();

        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(array));
        ArrayList<User> list2 = (ArrayList)in.readObject();

        // list2에 있는 user 목록들은 그대로
        list.remove(2);

        for (int i=0; i<list2.size(); i++) {
            System.out.println(list2.get(i));
        }
    }
}
