package cn.llanc.demo2;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service("customerService")
@Scope(value = "prototype")
/**
 * @Scopede 默认值为singleton (单例模式)
 * 其他取值  prototype(多例模式)
 *          request
 *          session
 *          globalsession
 */
public class CustomerService {
    @PostConstruct
    /**
     * init-method
     */
    public void init(){
        System.out.println("Init ...");
    }

    public void save(){
        System.out.println("Save ...");
    }
    @PreDestroy
    /**
     * destory-method
     */
    public void destory(){
        System.out.println("Destory ...");
    }
}
