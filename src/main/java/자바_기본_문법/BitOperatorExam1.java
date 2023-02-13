package 자바_기본_문법;

public class BitOperatorExam1 {
    public static void main(String[] args) {
        int a = 4;
        int b = a >> 1; // 2^1 으로 나눈다.
        System.out.println(b);

        int c = 4;
        int d = c << 1; // 2^1 으로 곱한다.
        System.out.println(d);

        // 숫자 4를 1byte로 표현하면
        // 00000100
        // int는 4byte이기 때문에 숫자 4
        // 00000000 00000000 00000000 00000100 이 된다. (3의 경우 00000011)
        // 우측으로 1 시프트
        // 00000000 00000000 00000000 00000010 2가된다.
    }
}
