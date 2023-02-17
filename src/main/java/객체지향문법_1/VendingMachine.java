package 객체지향문법_1;

public class VendingMachine {
    // field (가지는 것들)

    // 생성자
    // method
    public String pushProductButton(int menuId) {
        System.out.println(menuId+"를 전달받았습니다.");
        return "콜라";
    }

    public static void printVersion() {
        System.out.println("v1.0");
    }
}
