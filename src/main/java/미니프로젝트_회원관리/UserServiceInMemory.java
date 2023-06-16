package 미니프로젝트_회원관리;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// 메모리상에 User정보를 관리하는 클래스
public class UserServiceInMemory implements UserService {
    private List<User> users;

    public UserServiceInMemory() {
        this.users = new ArrayList<>();
    }

    public UserServiceInMemory(List<User> users) {
        this.users = users;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public boolean updateUser(User user) {
        boolean deleteFlag = deleteUser(user.getEmail());
        if (deleteFlag) {
            users.add(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean exists(String email) {
        if (findIndex(email) >= 0)
            return true;
        else
            return false;
    }

    private int findIndex(String email) {
        int findIndex = -1;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(email)) {
                findIndex = i;
                break;
            }
        }
        return findIndex;
    }

    @Override
    public boolean deleteUser(String email) {
        int findIndex = findIndex(email);
        if (findIndex > -1) {
            users.remove(findIndex);
            return true;
        } else {
            return false;
        }
    }


    @Override
    public Iterator<User> getUsers() {
        return users.iterator();
    }
}
