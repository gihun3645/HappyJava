package 객체지향문법_3.myproject;

import 객체지향문법_3.fw.Controller;

public class FirstController extends Controller {
    @Override
    protected void run() {
        System.out.println("별도로 동작하는 코드 111111");
    }

    // protect 걸어서 안됨
//    @Override
//    protected void init() {
//        System.out.println("내마음대로 init");
//    }
}
