package 미니프로젝트_회원관리;

import java.util.Iterator;
import java.util.List;

public
interface UserService {
    // 회원정보를 등록한다.
    public void addUser(User user);
    // 회원정보를 수정한다. user.getEmail()에 해당하는 회원정보를 수정한다.
    public boolean updateUser(User user);
    // 회원정보를 삭제한다.
    public boolean deleteUser(String email);
    // 모든 회원정보를 반환한다.
    public Iterator<User> getUsers();
    // 이메일에 해당하는 회원정보가 있을 경우 0보다 큰 값을 반환
    public boolean exists(String email);
}
