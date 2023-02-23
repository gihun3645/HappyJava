package 객체지향문법_3;

public class Car2Exam02 {
    public static void main(String[] args) {
//        Bus2 b = new Bus2();
//        b.run(); // 후륜구동으로 동작하도록한다.
//
//        SportsCar s1 = new SportsCar("sportsCar!!!");
//        s1.run();
//
//        Car2 c = new SportsCar("1"); // new 뒤에 어떤 클래스가 오느냐에 따라 결과가 달라짐
//        c.run();

        // Car2를 2개 참조할 수 있는 배열을 선언
        Car2[] array = new Car2[2];
        array[0] = new Bus2();
        array[1] = new SportsCar("sportsCar!!");
        for(Car2 c2 : array) {
            c2.run();
        }
//        Car2() 생성자 출력
//        Bus2 기본생성자
//        Car2() 생성자 출력
//        후륜구동으로 동작하도록한다.
//        사륜구동으로 움직인다.
    }
}
