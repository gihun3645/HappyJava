package 객체지향문법_3;

public class StringExam {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "hello";
        String str3 = new String("hello");
        String str4 = new String("hello");

        // 래퍼런스 타입에서 ==은 같은 것을 참조하냐 의미임
        // String을 쓸 때는 new를 쓰지 않는게 좋음
        // 메모리를 적게 씀
        if(str1 == str2)
            System.out.println("str1 == str2");
        if(str1 == str3)
            System.out.println("str1 == str3");
        if(str3 == str4)
            System.out.println("str3 == str4");

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
    }
}
