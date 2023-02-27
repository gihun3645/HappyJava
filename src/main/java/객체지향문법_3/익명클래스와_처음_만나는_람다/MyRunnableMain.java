package 객체지향문법_3.익명클래스와_처음_만나는_람다;

public class MyRunnableMain {
    public static void main(String[] args) {
        MyRunnable r = new MyRunnable() {
            @Override
            public void run() {
                System.out.println("myrunnable run!!!");
            }
        };

        r.run();
    }
}
