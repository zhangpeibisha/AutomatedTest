package org.nix.service.product.result;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/7/1
 */
public class QuerySingleProductInfoResult {

    private String channelId;
    private int isFlashSale;
    private int status;
    private int saledQuantity;
    private int stockQuantity;
    private int subscribeCount;
    private String startTime;
    private String endTime;
    private String transactionId;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public int getIsFlashSale() {
        return isFlashSale;
    }

    public void setIsFlashSale(int isFlashSale) {
        this.isFlashSale = isFlashSale;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSaledQuantity() {
        return saledQuantity;
    }

    public void setSaledQuantity(int saledQuantity) {
        this.saledQuantity = saledQuantity;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public int getSubscribeCount() {
        return subscribeCount;
    }

    public void setSubscribeCount(int subscribeCount) {
        this.subscribeCount = subscribeCount;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "QuerySingleProductInfoResult{" +
                "channelId='" + channelId + '\'' +
                ", isFlashSale=" + isFlashSale +
                ", status=" + status +
                ", saledQuantity=" + saledQuantity +
                ", stockQuantity=" + stockQuantity +
                ", subscribeCount=" + subscribeCount +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", transactionId='" + transactionId + '\'' +
                '}';
    }
}
