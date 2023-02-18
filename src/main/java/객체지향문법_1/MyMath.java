package 객체지향문법_1;

public class MyMath {
    // 자동생성 - 기본생성자는 생성자가 없을 경우 컴파일할 때 자동으로 생성한다.
    private MyMath() {}
    // 생성자의 접근 제한자가 private 하다는 것은 인스턴스를 생성을 못하게 한다는 의미
    public static int abs(int x) {
        if(x < 0)
            return x * -1;
        else
            return x;
    }
}
