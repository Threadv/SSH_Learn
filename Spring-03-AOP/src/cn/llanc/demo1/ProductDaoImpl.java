package cn.llanc.demo1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductDaoImpl implements ProductDao {
    @Override
    public void save() {
        System.out.println("ProductDaoImpl Save..");
    }

    @Override
    public void update() {
        System.out.println("ProductDaoImpl Update..");
    }

    @Override
    public void find(){
        System.out.println("ProductDaoImpl Find..");
        //int x=3/0;
    }

    @Override
    public String delete() {
        System.out.println("ProductDaoImpl Delete..");
        return "Log：删除记录\tTime:"+new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(new Date());
    }
}
