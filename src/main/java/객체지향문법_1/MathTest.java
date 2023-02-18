package 객체지향문법_1;

public class MathTest {
    public static void main(String[] args) {
        int value = Math.abs(-5);
        System.out.println(value);

        // 안됨
        // Math m = new Math();

        // Math 클래스를 만든 사람은 여러 개 인스턴스를 생성하지 못하게하므로써
        // 메모리를 절약할 수 있도록 하고 Math.메소드() 형식으로 쉽게 호출하도록 만들었다.
        // (인스턴스를 생성하지 못하도록 생성자를 private하게 만들었다.)
    }
}
