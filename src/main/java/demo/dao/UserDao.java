package demo.dao;

import demo.entity.User;

import java.util.List;

/**
 * @author: GMH
 * @create: 2020-02-07
 * @Description：
 * @Modified By：
 * @Version: 1.0.0
 */
public interface UserDao {
    List<User> findById(int id);
    List<User> findByName(String name);
    int insertData(User user);
    int deleteData(int id);
    int updateData(User user);
    List<User> findByNameIf(User user);
    List<User> findByIdForeach(User user);
}
