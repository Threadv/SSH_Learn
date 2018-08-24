package cn.llanc.demo4;

/**
 * @author 刘兰聪
 * @date 2018-08-09 11:09
 */
public interface TransferDaoInterface {
    public void outMoney(String from, Double money);
    public void inMoney(String in, Double money);
}
