package 객체지향문법_2;

public class CarExam01 {
    public static void main(String[] args) {
        Bus b1 = new Bus();
        b1.run();
        b1.안내방송();

        // 메소드가 오버라이딩 되면 무조건 오버라이딩 된 메소드가 실행된다.
        Car c1 = new Bus(); // 버스는 자동차다.
        c1.run(); // 그(c1)자동차는 달린다.
//        c1.안내방송();

        // Bus 인스턴스를 Car 타입으로 참조하면 Car 타입의 메소드만 사용가능하다.
        // 그런데, Bus가 가지고 있는 추가적인 메소드를 사용하려면 어떻게 해야할까?

        // c1이 참조하는 Bus 인스턴스를 원래의 Bus 형태로 참조해서 사용하겠다고 선언
        // c1이 참조하는 인스턴스를 b2도 참조하라는 의미
        Bus b2 = (Bus)c1;
        // Bus b2 = c1; 은 안됨

        Car c2 = new SuperCar();
        c2.run(); // 사륜구동으로 달린다.
    }
}
