package 배열과_컬렉션프레임워크.제네릭과_컬렉션프레임워크;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class SetExam2 {
    public static void main(String[] args) {
        // Hash 라는 알고리즘이 나오면 Object가 가지고 있는 equals와 hashCode 메소드를 오버라이딩 해야한다.
        Set<MyData> mySet = new HashSet<>();
        mySet.add(new MyData("kim", 500));
        mySet.add(new MyData("lee", 200));
        mySet.add(new MyData("hong", 700));
        // equals 와 hashcode 가 있어서 중복된 값이 안나옴
        mySet.add(new MyData("hong", 700));


        // Iterator를 사용하는 패턴
        Iterator<MyData> iterator = mySet.iterator();
        while (iterator.hasNext()){
            MyData myData = iterator.next();
            System.out.println(myData);
        }
    }
}

class MyData {
    private String name;
    private int value;

    public MyData(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("equals!!!");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyData myData = (MyData) o;
        return value == myData.value && Objects.equals(name, myData.name);
    }

    @Override
    public int hashCode() {
        System.out.println("hashcode!!!");
        return Objects.hash(name, value);
    }

    // toString 메소드를 오버라이딩해야 정상적인 값을 출력할 수 있음

    @Override
    public String toString() {
        return "MyData{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
