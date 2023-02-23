package 객체지향문법_3.fw;

/*
Controller의 종류가 여러개더라.
초기화 - 같은 코드
실행 - 다른 코드
마무리 - 같은 코드
*/


public abstract class Controller {
    // protected는 같은 package이거나 상속받았을 경우 접근 가능하다.
    // final 키워드가 붙으면 오버라이딩이 불가하다.
    protected final void init() {
        System.out.println("초기화 하는 코드");
    }

    protected final void close() {
        System.out.println("마무리 하는 코드");
    }

    protected abstract void run(); // 매번다른 코드

    public void execute() {
        // 초기화
        this.init();
        // 실행
        this.run();
        // 마무리
        this.close();
    }
}