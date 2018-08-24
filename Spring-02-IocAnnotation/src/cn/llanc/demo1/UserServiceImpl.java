package cn.llanc.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService{

//    @Autowired
//    @Qualifier(value="userDao")
    @Resource(name="userDao")
    /**
     * @Autowired 按照类型注入
     * @Qualifier(value="Name") 配合@Autowired 使按照名称注入 此时要注意名称相同
     *
     * 以上两个注解同时使用时可以使用@Resource((name="Name")代替
     */
    private UserDaoImpl userDaoImpl;

    @Override
    public void save() {
        userDaoImpl.save();
    }
}
