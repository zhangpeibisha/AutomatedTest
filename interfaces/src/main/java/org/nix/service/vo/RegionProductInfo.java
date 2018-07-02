package org.nix.service.vo;

import java.util.List;

/**
 * 3.3	分时商品信息类
 * @author zhangpei
 * @version 1.0
 * @date 2018/7/1
 */
public class RegionProductInfo {

    private String title;
    private List<ProductInfo> productInfos;
    private String startTime;
    private String endTime;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ProductInfo> getProductInfos() {
        return productInfos;
    }

    public void setProductInfos(List<ProductInfo> productInfos) {
        this.productInfos = productInfos;
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

    @Override
    public String toString() {
        return "RegionProductInfo{" +
                "title='" + title + '\'' +
                ", productInfos=" + productInfos +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
