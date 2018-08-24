package cn.llanc.demo3;

import javax.annotation.Resource;

/**
 * xml和注解混合开发，由xml管理bean 注解进行属性注入
 */
public class ProductService {
    @Resource(name = "productDao")
    private ProductDao productDao;
    @Resource(name = "orderDao")
    private OrderDao orderDao;

    public void save(){
        productDao.save();
        orderDao.save();
        System.out.println("ProductService Save...");
    }
}
