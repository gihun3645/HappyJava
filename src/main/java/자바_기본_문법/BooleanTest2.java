package 자바_기본_문법;

public class BooleanTest2 {
    public static void main(String[] args) {
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        boolean flag5 = false;
        boolean flag6 = false;

        // &&는 앞이 거짓이면 뒤는 실생하지 않는다.
        flag1 = 10 > 5 && 5 < 20;
        flag2 = 10 > 5 & 5 < 20;
        // || 역시 앞이 참이면 뒤는 실행하지 않는다.
        flag3 = 10 >= 10 || 5 > 6;
        flag4 = 10 >= 10 | 5 > 6;
        flag5 = 10 == 10 ^ 5 == 4;
        flag6 = !flag5;

        System.out.println(flag1);
        System.out.println(flag2);
        System.out.println(flag3);
        System.out.println(flag4);
        System.out.println(flag5);
        System.out.println(flag6);
    }
}
