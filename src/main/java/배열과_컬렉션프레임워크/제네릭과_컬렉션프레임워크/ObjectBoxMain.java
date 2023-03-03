package 배열과_컬렉션프레임워크.제네릭과_컬렉션프레임워크;

public class ObjectBoxMain {
    public static void main(String[] args) {
        ObjectBox box = new ObjectBox();
        box.set("kim");
        // Object 타입으로 받아서 리턴하기 때문에 String 타입으로 형변환
        String str = (String)box.get();
        System.out.println(str.toUpperCase());

        box.set(new Integer(5));
        Integer i = (Integer)box.get();
        System.out.println(i.intValue());
    }
}
