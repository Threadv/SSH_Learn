package bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

public class UserImpl implements UserInterface {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setUp(){
        System.out.println("初始化");
    }

    public void destroy(){
        System.out.println("销毁");
    }

    public UserImpl(String name) {
        this.name = name;
    }

    @Override
    public void save() {
        System.out.println("Save Mothed...");
    }
}
