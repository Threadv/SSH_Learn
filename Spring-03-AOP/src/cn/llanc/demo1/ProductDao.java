package cn.llanc.demo1;

import org.aspectj.lang.JoinPoint;

public interface ProductDao {
    public void save();
    public void update();
    public void find();
    public String delete();
}
