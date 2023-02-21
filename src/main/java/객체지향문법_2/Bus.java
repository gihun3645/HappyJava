package 객체지향문법_2;

// Bus는 자동차의 한 종류다.
// 버스를 일반화 시키면 자동차라 말할 수 있고.
// 자동차를 확장하면 버스가 될 수 있다.
public class Bus extends Car{
    public void 안내방송() {
        System.out.println("안내방송하다.");
    }
}