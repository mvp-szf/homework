package lagou;

import java.math.BigDecimal;

/**
 * 手机卡类
 * @author Hunter
 * @date 2020/6/29
 **/

public class PhoneCard {

    //卡类型
    private String cardType;

    //号码
    private String number;

    //用户名
    private String username;

    //密码
    private String password;

    //余额
    private BigDecimal balance;

    //通话时长
    private double talkTime;

    //上网流量
    private double netFlow;

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public double getTalkTime() {
        return talkTime;
    }

    public void setTalkTime(double talkTime) {
        this.talkTime = talkTime;
    }

    public double getNetFlow() {
        return netFlow;
    }

    public void setNetFlow(double netFlow) {
        this.netFlow = netFlow;
    }

    public void show(){
        System.out.println("卡号: " + number + " \n用户名: " + username + " \n当前余额: " + balance);
    }


}
