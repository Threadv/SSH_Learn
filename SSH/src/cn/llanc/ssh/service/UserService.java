package cn.llanc.ssh.service;

import cn.llanc.ssh.domain.User;

import java.util.List;

/**
 * 用户注册的业务层接口
 * @author 刘兰聪
 * @date 2018-08-13 10:40
 */
public interface UserService {

    void save(User user);
    void update(User user);
    void delete(User user);
    User findOne(Integer id);
    List<User> findMoreByHql();
    List<User> findMoreByQbc();
}
