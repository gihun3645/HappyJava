package 객체지향문법_2;

public class BookExam01 {
    public static void main(String[] args) {
        Book b1 = new Book();
        // 필드를 직접 접근 하는 것은 저오 은닉 관점에서 안좋다.
        // 외부에서 접근하지 못하도록 public 접근제한자를 private 접근제한자로 수정한다.
//        b1.price = 100;
//        System.out.println(b1.price);

        b1.setTitle("김성박의 즐거운 자바");
        b1.setPrice(500);
        System.out.println(b1.getPrice()); // 500
        System.out.println(b1.getTitle());
        // getter 메소드를 이용해 값을 가공해 반환할 수 있다.
    }
}
