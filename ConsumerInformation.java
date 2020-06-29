package lagou;

import java.math.BigDecimal;

/**
 * 用户消费信息类
 * @author Hunter
 * @date 2020/6/29
 **/

public class ConsumerInformation {

    //统计通话时长
    private double callTimeSum;

    //统计上网流量
    private double netFlowSum;

    //每月消费金额
    private BigDecimal  countSum;

    public double getCallTimeSum() {
        return callTimeSum;
    }

    public void setCallTimeSum(double callTimeSum) {
        this.callTimeSum = callTimeSum;
    }

    public double getNetFlowSum() {
        return netFlowSum;
    }

    public void setNetFlowSum(double netFlowSum) {
        this.netFlowSum = netFlowSum;
    }

    public BigDecimal getCountSum() {
        return countSum;
    }

    public void setCountSum(BigDecimal countSum) {
        this.countSum = countSum;
    }
}
