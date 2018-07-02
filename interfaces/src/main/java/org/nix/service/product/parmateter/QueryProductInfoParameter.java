package org.nix.service.product.parmateter;

import java.util.List;

/**
 * 4.3	秒杀品库存查询参数
 * @author zhangpei
 * @version 1.0
 * @date 2018/7/1
 */
public class QueryProductInfoParameter {

    private String channelId;
    private List<String> productIds;
    private long transTime;
    private String transactionId;

    public QueryProductInfoParameter(String channelId, List<String> productIds, long transTime, String transactionId) {
        this.channelId = channelId;
        this.productIds = productIds;
        this.transTime = transTime;
        this.transactionId = transactionId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public List<String> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<String> productIds) {
        this.productIds = productIds;
    }

    public long gettransTime() {
        return transTime;
    }

    public void settransTime(long transTime) {
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
        return "QueryProductInfoParameter{" +
                "channelId='" + channelId + '\'' +
                ", productIds=" + productIds +
                ", transTime=" + transTime +
                ", transactionId='" + transactionId + '\'' +
                '}';
    }
}
