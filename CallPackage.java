package lagou;

import java.math.BigDecimal;

/**
 * 通话套餐类
 * @author Hunter
 * @date 2020/6/29
 **/

public class CallPackage extends PackageAbstract implements CallService {

    //通话时长
    private double talkTime;

    //短信套数
    private Integer smsNum;

    public double getTalkTime() {
        return talkTime;
    }

    public void setTalkTime(double talkTime) {
        this.talkTime = talkTime;
    }

    public Integer getSmsNum() {
        return smsNum;
    }

    public void setSmsNum(Integer smsNum) {
        this.smsNum = smsNum;
    }

    public BigDecimal getCosByMonth(){
        return super.costByMonth;
    }

    @Override
    public void show() {
        System.out.println("CallPackage{" +
                "talkTime=" + talkTime +
                ", smsNum=" + smsNum +
                ", cosByMonth=" + costByMonth +
                '}');
    }

    @Override
    public void callTalk(double callTime, PhoneCard phoneCard) {
        System.out.println(phoneCard.getUsername() + "正在通话.. " + callTime + "分钟");
    }
}
