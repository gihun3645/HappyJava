package 배열과_컬렉션프레임워크.배열;

import java.util.Arrays;
import java.util.Comparator;

public class Array17_2 {
    public static void main(String[] args) {
        // 5새의 items을 참조할 수 있는 배열을 만듦
        Item[] items = new Item[5];
        items[0] = new Item("Java", 5000);
        items[1] = new Item("파이썬", 4000);
        items[2] = new Item("C#", 4500);
        items[3] = new Item("자바스크립트", 6000);
        items[4] = new Item("Dart", 2000);

        // sort(Object[]) - Object는 모든 객체의 조상이니깐, 어떤 객체의 배열이든 올 수 있다.
        // 기준을 정해줘야험
//        Arrays.sort(items, new ItemSorter());

        // 이름없는 객체로도 가능
//        Arrays.sort(items, (Object o1, Object o2) -> {
//                    Item item1 = (Item) o1;
//                    Item item2 = (Item) o2;
//                    return item1.getName().compareTo(item2.getName());
//                }
//        );

        // 동일한 결과
        Arrays.sort(items, (item1, item2) -> item1.getName().compareTo(item2.getName()));
        for (Item item : items) {
            System.out.println(item);
        }
    }
}

class ItemSorter implements Comparator {
    // o1 - o2
    @Override
    public int compare(Object o1, Object o2) {
        Item item1 = (Item) o1;
        Item item2 = (Item) o2;
        return item1.getName().compareTo(item2.getName());
    }
}

// Comparable은 어떤 Item이 큰지, 작은지 기준을 정하는 인터페이스
class Item implements Comparable {
    private String name;
    private int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // 파라미터로 들어온 Object나 내 자신을 비교하는 메소드
    // CompareTo에는 Object를 잘 받아들이도록 했지만, 실제로는 Item이 들어온다.
    // 홍길동, 고길동

    // 문자 순서 대로 배열하라
//    @Override
//    public int compareTo(Object o) {
//        Item d = (Item)o;
//        return this.name.compareTo(d.name); // 양수, 0, 음수
//    }

    // 금액 순으로 배열하라
    @Override
    public int compareTo(Object o) {
        Item d = (Item) o;
        // 자신의 가격과 들어온 아이템의 가격을 비교
        return this.price - d.price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // 객체의 값을 출력하기 위해 오브젝트가 갖고 있는 toString 메소드를 출력

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}