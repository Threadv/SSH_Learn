package cn.llanc.ssh.dao.Impl;

import cn.llanc.ssh.dao.UserDao;
import cn.llanc.ssh.domain.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * @author 刘兰聪
 * @date 2018-08-13 10:43
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {


    @Override
    public void save(User user) {
        this.getHibernateTemplate().save(user);
    }

    @Override
    public void update(User user) {
        this.getHibernateTemplate().update(user);
    }

    @Override
    public void delete(User user) {
        this.getHibernateTemplate().delete(user);
    }

    @Override
    public User findOne(Integer id) {
        User user= this.getHibernateTemplate().get(User.class, 1);
        return user;
    }

    @Override
    public List<User> findMoreByHql() {
        List<User> list= (List<User>) this.getHibernateTemplate().find("from User");
        return list;

    }

    @Override
    public List<User> findMoreByQbc() {
        DetachedCriteria detachedCriteria=DetachedCriteria.forClass(User.class);
        List<User> list= (List<User>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
        return list;
    }
}
