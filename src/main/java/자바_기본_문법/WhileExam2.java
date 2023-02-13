package 자바_기본_문법;

public class WhileExam2 {
    public static void main(String[] args) {
        int i = 1;
        while (true) {
            // break 는 반복문을 빠져나감 continue는 '조건문'만 실행시키지 않고 반복문은 이어서 실행
            if(i == 1) break;
            System.out.println(i);
            i++;
        }
    }
}
