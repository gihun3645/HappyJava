package Thread;

// 동시에 실행시키기

// 규칙
// 1. Thread 클래스를 상속받는다.
public class MyThread extends Thread {

    private String str;

    public MyThread(String str) {
        this.str = str;
    }

    // 2. run() 메소드를 오버라이딩 한다.
    // 동시에 실행시키고 싶은 코드를 작성한다.
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
