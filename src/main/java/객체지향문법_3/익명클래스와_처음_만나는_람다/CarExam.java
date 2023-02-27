package 객체지향문법_3.익명클래스와_처음_만나는_람다;

public class CarExam {
    public static void main(String[] args) {
        // Car를 상속받고 있는 이름없는 객체
        Car c1 = new Car(){
            @Override
            public void a() {
                System.out.println("이름없는 객체의 a()메소드 오버라이딩");
            }
        };

        c1.a();
    }
}
