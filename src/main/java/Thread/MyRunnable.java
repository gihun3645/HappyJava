package Thread;

// 1. MyRunnable 인터페이스를 구현한다.
// Runnable 인터페이스를 구현한다는 것에서 차이가 있음
public class MyRunnable implements Runnable {

    private String str;

    public MyRunnable(String str) {
        this.str = str;
    }

    // 2. run() 메소드를 오버라이딩 한다.
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("--- " + name + " ---");

        // 1초 마다 str 을 출력, 총 10번을 출력하는 프로그램을 작성하시오
        for (int i = 0; i < 10; i++) {
            System.out.print(str);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } // for
    }
}
