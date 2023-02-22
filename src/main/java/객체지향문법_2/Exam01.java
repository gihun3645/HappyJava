package 객체지향문법_2;

public class Exam01 {
    public static void main(String[] args) {
        Parent p1 = new Parent();
        System.out.println(p1.i);
        p1.printI();
        System.out.println("----------------");
        Child c1 = new Child();
        System.out.println(c1.i);
        c1.printI();
        System.out.println("----------------");
        Parent p2 = new Child(); // Child는 Parent의 후손이다. 혹은 자식이다.
        // 메소드가 오버라이딩 되면 무조건 자식의 메소드가 실행된다.
        // Parent 타입으로 참조하지만 메소드는 오버라이딩 되었기 때문에 자식의
        // printI() 메소드가 실행되고 자식의 printI() 메소드는 자식의 i값을 출력해서 15가 출력된다.
        System.out.println(p2.i);
        p2.printII(); // 10
        // p2.printII() 메소드를 실행했을 때, 필드도 오버라이딩 되면
        // 무조건 자식 것이 사용된다면 30이 나올거임, 그런데 10이 출력됨

        // 필드가 오버라이딩 되서 자식의 값이 사용된다면
        // 부모 클래스를 만든 사람이 예상하지 못한 결과가 출력될 것이기 떄문에 필드는 (부모)타입을 따라감
        p2.printI();
    }
}
