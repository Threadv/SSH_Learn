package cn.llanc.demo1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
    public void save(){
        System.out.println("Save....");
    }
    public void update(){
        System.out.println("Update....");
    }
    public String delete(){
        System.out.println("Delete....");
        return ("删除日期:\t" + new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(new Date()));
    }
    public void find(){
        System.out.println("Find....");
    }
}
