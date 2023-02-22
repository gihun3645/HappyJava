package 객체지향문법_2;

public class CarExam02 {
    public static void main(String[] args) {
        Car c1 = new Car();
        System.out.println(c1); // println(Object x);
    }
}

// 부모타입의 변수로 자식인스턴스를 참조할 수 있다.
// 조상타입의 변수로 후손인스턴스를 참조할 수 있다.
// Car c1 = nwe Bus();
// Car c2 = new 이층버스(); // 이층버스는 Car의 자손이다.
// Object o1 = new Car();
// Object o2 = new Bus();
// Object o3 = new 이층버스();
// System.out.println(o1.toString()); == System.out.println(o1);