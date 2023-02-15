package 객체지향문법_1;

public class VendingMachineMain {
    public static void main(String[] args) {
        VendingMachine vm1 = new VendingMachine(); // 자판기만 메모리에 생성

        // 리턴된 "콜라"는 product 변수가 참조하게 됨
        String product = vm1.pushProductButton(100);
        System.out.println(product);
    }
}
