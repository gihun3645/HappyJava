package 미니프로젝트_회원관리;


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *  파일에서 List<User>정보를 저장하거나 읽어오는 기능
 */

public class UserDao {
  private String filename;
  public UserDao(String filename) {
      this.filename = filename;
  }

  public void saveUser(Iterator<User> iter) {
      List<User> users = new ArrayList<>();
      while (iter.hasNext()) {
          User user = iter.next();
          users.add(user);
      }
      try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
          out.writeObject(users);
      } catch (Exception ex) {
          ex.printStackTrace();
      }
  }

  public List<User> getUsers() {
      File file = new File(filename);
      // 파일이 없으면 빈 리스트를 리턴
      if(!file.exists()) {
          return new ArrayList<>();
      }

      List<User> list = null;
      try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
          list = (List<User>)in.readObject();
      } catch (Exception ex) {
          ex.printStackTrace();
      }
      return list;
  }
}
