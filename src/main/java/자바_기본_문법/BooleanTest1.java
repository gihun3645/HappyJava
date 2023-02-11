package 자바_기본_문법;

public class BooleanTest1 {
    public static void main(String[] args) {
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        boolean flag5 = false;

        flag1 = 10 > 5;
        flag2 = 10 < 5;
        flag3 = 10 >= 10;
        flag4 = 10 <= 10;
        flag5 = 10 == 10;

        System.out.println(flag1);
        System.out.println(flag2);
        System.out.println(flag3);
        System.out.println(flag4);
        System.out.println(flag5);
    }
}
