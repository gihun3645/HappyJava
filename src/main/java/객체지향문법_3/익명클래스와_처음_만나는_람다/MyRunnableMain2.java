package 객체지향문법_3.익명클래스와_처음_만나는_람다;

public class MyRunnableMain2 {
    public static void main(String[] args) {

        MyRunnable myRunnable = new MyRunnable() {
            @Override
            public void run() {
                System.out.println("hello!!!!");
            }
        };

        RunnableExecute runnableExecute = new RunnableExecute();
        System.out.println("------------");
        runnableExecute.execute(myRunnable);
        // 가능
//        runnableExecute.execute(new MyRunnable() {
//            @Override
//            public void run() {
//                System.out.println("hello!!!!");
//            }
//        });
        // 가능2 => 람다인터페이스 - 메소드를 하나만 가지고 있는 인터페이스
        runnableExecute.execute(() -> {
            System.out.println("hello!!!!!");
        });
        System.out.println("------------");
    }
}
