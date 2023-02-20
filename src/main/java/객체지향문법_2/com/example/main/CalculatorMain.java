package 객체지향문법_2.com.example.main;

import 객체지향문법_2.com.example.util.Calculator;

public class CalculatorMain {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        int value = cal.plus(10, 100);
        System.out.println(value);

        // 같은 이름의 클래스를 사용할 땐, 하나는 import를 해서 사용하고 또 다른 하나는 클래스명 앞에 패키지명까지 붙여서 사용해야함
        객체지향문법_2.com.example.util2.Calculator cal2 = new 객체지향문법_2.com.example.util2.Calculator();
        int value2 = cal2.divine(100, 100);
        System.out.println(value2);
    }
}
