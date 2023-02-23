package 객체지향문법_3;

public class CarExam02 {
    public static void main(String[] args) {
        Car c1 = new Car();
        System.out.println(c1);
        c1.printName(); // null
        System.out.println("-------------------------");
        Car c2 = new Car("urstory");
        c2.printName(); // urstory
    }
}
