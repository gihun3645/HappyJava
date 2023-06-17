package Thread;

public class MyThreadExam2 {
    public static void main(String[] args) {
        String name = Thread.currentThread().getName();
        System.out.println("Thread name : " + name);
        System.out.println("start!");

        MyThread mt1 = new MyThread("*");
        MyThread mt2 = new MyThread("+");

        // 3. Thread 인스턴스를 생성하는데, 생성자에 Runnable 인스턴스를 넣어준다.
        Thread t1 = new Thread(mt1);
        Thread t2 = new Thread(mt2);

        // 4. Thread 가 가지고 있는 start 메소드를 호출한다.
        t1.start();
        t2.start();

        System.out.println("end!");
    }
}