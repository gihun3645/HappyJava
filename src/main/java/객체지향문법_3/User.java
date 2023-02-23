package 객체지향문법_3;

public class User {
    private String email;
    private String password;
    private String name;

    // 생성자를 하나라도 만들게 되면 기본생성자가 자동으로 만들어진다.
    // 이렇게 객체가 생성된 후, 그 상태를 변경할 수 없는 객체를 불변객체라고함
    public User(String name, String email) {
//        this.email = email;
//        this.name = name;
        // 반복적인 부분은 생성자안에서 자기자신을 호출할 수 있다.
        // 코드 중복을 해결할 수 있다. (this 생성자)
        // 가장 첫번째 줄에 나와야한다. (컴파일 에러 발생)
        this(name, email, null);
    }

    // 이름은 같지만 매개변수가 다름 => 생성자 오버로딩
    public User(String name, String email, String password) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
