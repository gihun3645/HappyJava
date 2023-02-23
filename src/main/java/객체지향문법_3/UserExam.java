package 객체지향문법_3;

public class UserExam {
    public static void main(String[] args) {
        User user = new User("김성박", "urstory@gmail.com");
        System.out.println(user.getName());
        System.out.println(user.getEmail());
        System.out.println(user.getClass());

        User user2 = new User("홍길동", "hong@exam.com", "1234");
//        System.out.println(user2.getName());
//        System.out.println(user2.getEmail());
//        System.out.println(user2.getPassword());
        // 일일히 출력하고 싶지 않다면 toString 메소드로 오버라이딩

        System.out.println(user2);
    }
}
