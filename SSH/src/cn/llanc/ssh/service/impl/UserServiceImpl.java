package cn.llanc.ssh.service.impl;

import cn.llanc.ssh.dao.UserDao;
import cn.llanc.ssh.domain.User;
import cn.llanc.ssh.service.UserService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 刘兰聪
 * @date 2018-08-13 10:42
 */
@Transactional
public class UserServiceImpl implements UserService {

    //注入UserDao
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);

    }

    @Override
    public User findOne(Integer id) {
        return userDao.findOne(id);
    }

    @Override
    public List<User> findMoreByHql() {
        return userDao.findMoreByHql();
    }

    @Override
    public List<User> findMoreByQbc() {
        return userDao.findMoreByQbc();
    }
}
