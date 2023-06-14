### DataInputStream, DataOutputStream

기본형 타입과 문자열을 읽고 쓸 수 있다.

```java
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
```

```java
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
```

### ByteArrayInputStream, ByteArrayOutPutStream

- byte[]에 데이터를 읽고 쓰기

```java
package decorator;

import java.io.ByteArrayOutputStream;

public class IOExam04 {
    public static void main(String[] args) throws Exception {
				// ByteArrayOutputStream 은 생성자에 아무것도 들어가지 않는다.
        int data1 = 1;
        int data2 = 2;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.write(data1); // data1의 마지막 1byte 저장한다.
        out.write(data2);
        out.close();

        // 꺼낼 때
        byte[] array = out.toByteArray();
        System.out.println(array.length);
        System.out.println(array[0]);
        System.out.println(array[1]);
    }
}
```

```java
package decorator;

import java.io.ByteArrayInputStream;

public class IOExam05 {
    public static void main(String[] args) throws Exception{
        byte[] array = new byte[2];
        array[0] = (byte)1;
        array[1] = (byte)2;
        ByteArrayInputStream in = new ByteArrayInputStream(array);

        int read1 = in.read();
        int read2 = in.read();
        int read3 = in.read(); // -1
        in.close();

        System.out.println(read1);
        System.out.println(read2);
        System.out.println(read3);
    }
}
```

### CharArrayReader, CharArrayWriter

- char[]에 데이터를 읽고 쓰기

### StringReader, StringWriter

- 문자열 읽고 쓰기

```java
package decorator;

import java.io.StringWriter;

public class IOExam06 {
    public static void main(String[] args) throws Exception{
        StringWriter out = new StringWriter();
        out.write("hello");
        out.write("world");
        out.write("!!!");
        out.close();

        String str = out.toString();
        System.out.println(str);
    }
}
```

```java
package decorator;

import java.io.StringReader;

public class IOExam07 {
    public static void main(String[] args) throws Exception{
        StringReader in = new StringReader("helloworld!!!");
        int ch = -1;

        while ((ch=in.read()) != -1) {
            System.out.print((char)ch);
        }
        in.close();
    }
}
```

## ObjectinputStream, ObjectOutputStream

- 직렬화 가능한 대상을 읽고 쓸 수 있다.
- 직렬화 가능한 대상은 기본형 타입 or java.io.Serializable 인터페이스를 구현하고 있는 객체이다.

## 객체를 저장한다.

```java
package io;

import java.io.Serializable;

public class User implements Serializable {
    private String email;
    private String name;
    private int birthYear;

    public User(String email, String name, int birthYear) {
        this.email = email;
        this.name = name;
        this.birthYear = birthYear;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }
}
```

## 객체를 읽어들인다.

```java
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
```

객체를 출력한다.

```java
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
```

## 다른 형태

```java
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
```

```java
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
```

```java
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
```

```java
package io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ObjectInputExam2 {
    public static void main(String[] args) throws Exception{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("/tmp/userlist.dat"));
        ArrayList<User> list = (ArrayList) in.readObject();
        in.close();
        for(int i=0; i< list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
```