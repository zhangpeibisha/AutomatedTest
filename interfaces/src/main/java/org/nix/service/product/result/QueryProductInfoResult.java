package org.nix.service.product.result;

import org.nix.service.vo.ProductInfo;

import java.util.List;

/**
 * 4.3	秒杀品库存查询结果
 * @author zhangpei
 * @version 1.0
 * @date 2018/7/1
 */
public class QueryProductInfoResult {

    private String channelId;
    private List<ProductInfo> productInfos;
    private String transactionId;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public List<ProductInfo> getProductInfos() {
        return productInfos;
    }

    public void setProductInfos(List<ProductInfo> productInfos) {
        this.productInfos = productInfos;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "QueryProductInfoResult{" +
                "channelId='" + channelId + '\'' +
                ", productInfos=" + productInfos +
                ", transactionId='" + transactionId + '\'' +
                '}';
    }
}
