package cn.llanc.ssh.dao;

import cn.llanc.ssh.domain.User;

import java.util.List;

/**
 * @author 刘兰聪
 * @date 2018-08-13 10:42
 */
public interface UserDao {
    void save(User user);

    void update(User user);

    void delete(User user);

    User findOne(Integer id);

    List<User> findMoreByHql();

    List<User> findMoreByQbc();
}
