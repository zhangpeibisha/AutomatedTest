package org.nix.service.product.parmateter;

/**
 * 4.1	秒杀数据查询参数
 * @author zhangpei
 * @version 1.0
 * @date 2018/7/3
 */
public class QueryRegionProductInfo {

    private String channelId;
    private long transTime;
    private String transactionId;

    public QueryRegionProductInfo(String channelId, long transTime, String transactionId) {
        this.channelId = channelId;
        this.transTime = transTime;
        this.transactionId = transactionId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public long getTransTime() {
        return transTime;
    }

    public void setTransTime(long transTime) {
        this.transTime = transTime;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "QueryRegionProductInfo{" +
                "channelId='" + channelId + '\'' +
                ", transTime='" + transTime + '\'' +
                ", transactionId='" + transactionId + '\'' +
                '}';
    }
}
