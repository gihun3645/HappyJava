package 객체지향문법_3.fw;

import 객체지향문법_3.myproject.FirstController;

public class ControllerMain {
    public static void main(String[] args) {
        Controller c1 = new FirstController();
        // excute만 따로 사용하도록 강제하려면, 다른 메소드에 protect 접근제한자를 붙이면 됨
        c1.execute();
    }
}
