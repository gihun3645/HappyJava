package 객체지향문법_3;

public class Bus2 extends Car2{
    public Bus2(){
        // 부모의 기본생성자가 없으면 super에 값을 넣어줘야한다.
        super("Bus!!"); // 부모의 기본 생성자를 호출하는 코드가 자동으로 삽입된다.
        System.out.println("Bus2 기본생성자");
    }
}
