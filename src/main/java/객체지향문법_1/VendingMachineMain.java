package 객체지향문법_1;

public class VendingMachineMain {
    public static void main(String[] args) {
        // static 한 메소드는 클래스명 다음에 사용한다. (규칙)
        VendingMachine.printVersion();
        VendingMachine vm1 = new VendingMachine(); // 자판기만 메모리에 생성


        // 리턴된 "콜라"는 product 변수가 참조하게 됨
        String product = vm1.pushProductButton(100);

        // 인스턴스를 참조해서도 가능은 하지만 권장하지 않음
        vm1.printVersion();
        System.out.println(product);

    }
}
