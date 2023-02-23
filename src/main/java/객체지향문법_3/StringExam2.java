package 객체지향문법_3;

public class StringExam2 {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = new String("hello");

        if(str1.equals(str2)) { // 값이 같으냐
            System.out.println("str1의 값과 str2의 값이 같다.");
        }

        String s = str1.toUpperCase();
        System.out.println(s); // HELLO
        System.out.println(str1); // hello
        // String은 불변 클래스라서 String이 갖고 있는 어떤 메소드를 호출해도 참조하는 어떤 String이던 변하지 않는다.

        String substring = str1.substring(3);
        System.out.println(substring);
        System.out.println(str1);
    }
}
