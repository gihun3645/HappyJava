package 객체지향문법_1;

public class MathBeanTest {
    // MathBean 클래스를 사용하려면 메모리에 올려야함
    // 메모리에 올리려면 new 연산자가 필요하다.
    public static void main(String[] args) {
        // static이 붙은 메소드는 메모리에 올리지 않아도 실행가능

        // MathBean()은 생성
        // MathBean 인스턴스가 만들어지고, Heap이라는 메모리에 올라감
        MathBean math = new MathBean(); // 인스턴스를 참조변수 math가 가리킴

        math.printClassName(); // MathBean
        math.printNumber(5000); // 5000
        int x = math.getOne();
        System.out.println(x); // 1
        int value = math.plus(200, 300);
        System.out.println(value); // 500
    }
}
