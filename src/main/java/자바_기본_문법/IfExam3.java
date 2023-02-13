package 자바_기본_문법;

public class IfExam3 {
    public static void main(String[] args) {
        int score = 50;

        if(score >= 90) {
            System.out.println("A");
        } else if(score >= 80) {
            System.out.println("B");
        } else if (score >= 70) {
            System.out.println("C");
        } else if (score >= 60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
        System.out.println("프로그램 종료");
    }
}
