package 미니프로젝트_회원관리;

import java.util.List;

public class UserMain {
    public static void main(String[] args) {
        UserUI userUI = new UserUI();
        UserDao userDao = new UserDao("/tmp/users.dat");
//        List<User> users = userDao.getUsers(); // 메모리상의 User 정보를 관리한다
        UserService userService = new UserServiceInMemory(userDao.getUsers());

        while (true) {
            int menuId = userUI.menu();

            if (menuId == 5) {
                System.out.println("종료합니다.");
                // users 정보를 저장한다.
                userDao.saveUser(userService.getUsers());
                // while문을 빠져나간다.
                break;
            } else if (menuId == 1) {
                User user = userUI.regUser();
                userService.addUser(user);
                System.out.println("등록되었습니다.");
            } else if (menuId == 2) {
                userUI.printUserList(userService.getUsers());
            } else if (menuId == 3) {
                // 사용자로 부터 이메일 주소를 입력받는다.
                String email = userUI.inputEmail();
                boolean isFindEmail = userService.exists(email);
                
                if (isFindEmail) {
                    User updateUser = userUI.inputUser(email);
                    userService.updateUser(updateUser);
                    System.out.println("수정되었습니다.");
                } else { // 찾지 못하였다
                    System.out.println("수정할 회원 정보가 없습니다.");
                }
            } else if (menuId == 4) {
                // 사용자로 부터 이메일 주소를 입력받는다.
                String email = userUI.inputEmail();
                boolean isFindEmail = userService.exists(email);
                if (isFindEmail) {
                    userService.deleteUser(email);
                    System.out.println("삭제하였습니다.");
                } else {
                    System.out.println("삭제할 회원 정보가 없습니다.");
                }
            }
        }
    }
}
