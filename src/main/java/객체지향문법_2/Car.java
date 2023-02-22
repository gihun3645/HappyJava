package 객체지향문법_2;

public class Car {
    public void run() {
        System.out.println("전륜구동으로 달린다.");
    }

    // Car를 출력하고 싶다면.

    @Override
    public String toString() {
        return "자동차!!!";
    }
}
