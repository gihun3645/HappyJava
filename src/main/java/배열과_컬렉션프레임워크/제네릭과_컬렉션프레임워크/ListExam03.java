package 배열과_컬렉션프레임워크.제네릭과_컬렉션프레임워크;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ListExam03 {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("kim");
        collection.add("lee");
        collection.add("hong");

        System.out.println(collection.size());

        Iterator<String> iter = collection.iterator();
        while(iter.hasNext()) {
            String str = iter.next();
            System.out.println(str);
        }
    }
}
