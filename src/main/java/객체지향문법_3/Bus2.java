package 객체지향문법_3;

public class Bus2 extends Car2 {

    public Bus2() {
        // 부모의 기본생성자가 없으면 super에 값을 넣어줘야한다.
        super("Bus!!"); // 부모의 기본 생성자를 호출하는 코드가 자동으로 삽입된다.
        System.out.println("Bus2 기본생성자");

        // 오버라이딩을 해야 문제가 발생하지 않는다.
        // 부모가 가지고 있는 추상메소드는 자식에서 반드시 구현을 헤줘야 한다.

    }

    @Override
    public void run() {
        System.out.println("후륜구동으로 동작하도록한다.");
    }
}
