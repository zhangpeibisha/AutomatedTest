package org.nix.service.product.parmateter;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/7/1
 */
public class QuerySingleProductInfoParameter {

    private String channelId;
    private String productId;
    private String transTime;
    private String transactionId;

    public QuerySingleProductInfoParameter(String channelId, String productId, String transTime, String transactionId) {
        this.channelId = channelId;
        this.productId = productId;
        this.transTime = transTime;
        this.transactionId = transactionId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTransTime() {
        return transTime;
    }

    public void setTransTime(String transTime) {
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
        return "QuerySingleProductInfoParmaeter{" +
                "channelId='" + channelId + '\'' +
                ", productId='" + productId + '\'' +
                ", transTime='" + transTime + '\'' +
                ", transactionId='" + transactionId + '\'' +
                '}';
    }
}
