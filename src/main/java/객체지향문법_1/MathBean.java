package 객체지향문법_1;

public class MathBean {
    // 매개변수도 없도 리턴 타입도 없음
    public void printClassName() {
        System.out.println("MathBean");
    }

    // 매개변수는 있고 리턴타입은 있음
    public void printNumber(int number) {
        System.out.println(number);
    }

    // 매개변수는 없고 리턴타입 있음
    public int getOne() {
        return 1;
    }

    // 매개변수 있고 리턴타입 있음
    public int plus(int x, int y) {
        return x+y;
    }
}
