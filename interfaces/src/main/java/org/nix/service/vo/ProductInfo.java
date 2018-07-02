package org.nix.service.vo;

/**
 * 3.2	商品信息类
 * @author zhangpei
 * @version 1.0
 * @date 2018/7/1
 */
public class ProductInfo {

    private String productId;
    private int isFlashSale;
    private int status;
    private int saledQuantity;
    private int stockQuantity;
    private int subscribeCount;
    private String startTime;
    private String endTime;
    private String detailInfo;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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

    public String getDetailInfo() {
        return detailInfo;
    }

    public void setDetailInfo(String detailInfo) {
        this.detailInfo = detailInfo;
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
                "productId='" + productId + '\'' +
                ", isFlashSale=" + isFlashSale +
                ", status=" + status +
                ", saledQuantity=" + saledQuantity +
                ", stockQuantity=" + stockQuantity +
                ", subscribeCount=" + subscribeCount +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", detailInfo='" + detailInfo + '\'' +
                '}';
    }
}
