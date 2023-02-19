package 객체지향문법_2;

public class StandardOutput {
    // 오버로딩
    public void println(boolean b) {
        System.out.println(b);
    }

    public void println(int i) {
        System.out.println(i);
    }

    public void println(double d) {
        System.out.println(d);
    }

    public void println(String s) {
        System.out.println(s);
    }

    // java StandardOutput
    public static void main(String[] args) {
        // StandardOutput 클래스의 메소드를 사용하려면 StandardOutput 클래스의 인스턴스를 생성해야한다.
        StandardOutput output = new StandardOutput();
        // 실행을 시키면 int, String, double, boolean을 받아들이는 println() 메소드가 차례대로 실행된다.
        output.println(100);
        output.println("hello");
        output.println(10.5);
        output.println(false);
    }
}
