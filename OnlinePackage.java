package lagou;

import java.math.BigDecimal;

/**
 * 上网套餐
 * @author Hunter
 * @date 2020/6/29
 **/

public class OnlinePackage extends PackageAbstract implements NetService {

    //上网流量
    private double netFlow;


    public double getNetFlow() {
        return netFlow;
    }

    public void setNetFlow(double netFlow) {
        this.netFlow = netFlow;
    }

    public BigDecimal getCosByMonth(){
        return super.costByMonth;
    }


    @Override
    public void show(){
        System.out.println("上网流量: " + netFlow + " \n每月资费: " + costByMonth);
    }

    @Override
    public void surfTheInternet(double netTime, PhoneCard phoneCard) {
        System.out.println(phoneCard.getUsername() + "正在上网.. " + netTime + "分钟");

    }
}
