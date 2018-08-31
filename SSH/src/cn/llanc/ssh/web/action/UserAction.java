package cn.llanc.ssh.web.action;

import cn.llanc.ssh.domain.User;
import cn.llanc.ssh.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 用户注册的Action类
 * @author 刘兰聪
 * @date 2018-08-13 10:37
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {
    // 模型驱动使用的对象
    private User user=new User();
    @Override
    public User getModel() {
        return user;
    }

    // Action自动按名次注入Service
    private UserService userService;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    /**
     * 保存注册信息
     * @return
     */
    public String save(){
        // 没有注入service需要用 WebApplicationContext 来获取bean
        // WebApplicationContext webApplicationContext= WebApplicationContextUtils
        //        .getWebApplicationContext(ServletActionContext.getServletContext());
        // UserService userService= (UserService) webApplicationContext.getBean("UserService");
        userService.save(user);
        return SUCCESS;
    }
}
