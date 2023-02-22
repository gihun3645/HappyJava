package 객체지향문법_2;

public class Book {
    private String title;
    private int price; // field price

    // 필드의 값을 수정하고 얻기 위한 메소드를 만든다. setter, getter
    // setter, getter 메소드를 "프로퍼티"라고 한다.
    // 아래의 예시에서는 "price 프로퍼티"라고 함
    public int getPrice() {
        // 메소드가 길어지면 메소드에서 선언된 지역변수인지 필드인지 착갈할 수 있기 때문에
        // 인스턴스 필드를 사용할 때는 this.price라고 적어 줄 수도 있다.
        return this.price; // this는 내 자신 인스턴스를 참조하는 예약어

        // this 클래스 메소드(static 메소드)에서 사용할 수 있는가?
        // => 없다
        // 클래스 메소드는 인스턴스가 생성이 되지 않아도 사용가능함
        // 메모리에 생성되는 시점이 다르기 때문에 클래스 메소드에서는 this를 사용할 수 없다.
    }

    public void setPrice(int price) { // 지역변수 price
        this.price = price; // this.price 인스턴스 변수
        // 매개변수로 받은 지역변수 price로 this.price를 초기화한다.
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
