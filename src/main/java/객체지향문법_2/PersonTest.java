package 객체지향문법_2;

public class PersonTest {
    public static void main(String[] args) {
//        Person p1; // p1은 null 이다.

        Person p1 = new Person();
        Person p2 = new Person();

        p1.name = "홍길동"; // 문자열은 new를 사용하지 않고 인스턴스를 사용할 수 있다. 되도록 new를 사용하지 말자(String 사용할땐)
        p1.address = "일산";
        p1.isVip = true;

        p2.name = "죠죠";
        p2.address = "서울";
        p2.isVip = true;

        System.out.println(p1.address);
        System.out.println(p1.name.length());
        System.out.println(p1.name);
        // System.out.println(p1.address.length()); // NullPointException
        // 아무것도 참조하지 않음
        System.out.println(p1.isVip);
        System.out.println("----------------------------");
        System.out.println(p2.address);
        System.out.println(p2.name);
        System.out.println(p2.name.length());
        System.out.println(p2.isVip);
    }
}
