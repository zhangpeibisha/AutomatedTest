package org.nix.service.product.info;

import org.nix.service.product.parmateter.QueryProductInfoParameter;
import org.nix.service.product.parmateter.QueryRegionProductInfo;
import org.nix.service.product.parmateter.QuerySingleProductInfoParameter;
import org.nix.utils.http.AbstractSystemTest;
import org.nix.utils.http.HttpResponse;
import org.nix.utils.http.Test;
import org.nix.utils.json.JacksonUtil;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试案例方法
 * 如果需要自定义客户端，
 * AbstractSystemTest.sendHttpRequest(String url, Object parameter, HttpResponse response)方法，
 * 在方法中重新定义请求方式即可
 * <p>
 * 构造方法的使用由使用者自己选择，具体内容
 * <p>
 * 对于使用 @Test 注解能够让方法得到执行，如果需要代理请自己调用代理对象进行处理。
 * 该类中只实现了对请求方法的代理，因为测试方法主要需要的是对请求进行处理。
 *
 * @author zhangpei
 * @version 1.0
 * @date 2018/7/1
 * @see org.nix.utils.http.AbstractInterfaceRequestProcessing
 */
public class ProductInfoTest extends AbstractSystemTest {

    public static String secret_key = "c5fkK157lBsy91uC";

    private static final String
            BASE_URL = "http://fstestmall.pizzahut.com.cn/Flashsale/api/";

    public static void main(String[] args) {
        ProductInfoTest test = new ProductInfoTest();
        try {
            test.sendRequest();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    /**
     * 4.3	秒杀品库存查询 正常访问
     */
    @Test
    public void queryProductInfo() throws IOException {
        String son = "QueryProductInfo";
        httpRequest(son, JacksonUtil.bean2Json(getQueryProductInfoParameter()));
    }

    /**
     * 4.2	秒杀单品状态查询 正常访问
     */
    @Test
    public void querySingleProductInfo() throws IOException {
        String son = "QuerySingleProductInfo";
        httpRequest(son, JacksonUtil.bean2Json(getQuerySingleProductInfoParmaeter()));
    }

    /**
     * 4.1	秒杀数据查询 正常访问
     *
     * @throws IOException
     */
    @Test
    public void queryRegionProductInfo() throws IOException {
        String son = "QueryRegionProductInfo";
        httpRequest(son, JacksonUtil.bean2Json(getQueryRegionProductInfo()));
    }


    /**
     * 设置秒杀品库存查询
     *
     * @return 参数实体
     */
    private QueryProductInfoParameter getQueryProductInfoParameter() {

        String channelId = "210002";
        List<String> productIds = new ArrayList<>();
        productIds.add("10002");
        productIds.add("10003");
        long timestamp = 1525762709000L;
        String transactionId = "725396974136597435435";

        QueryProductInfoParameter parameter =
                new QueryProductInfoParameter(channelId, productIds, timestamp, transactionId);
        return parameter;
    }

    private QuerySingleProductInfoParameter getQuerySingleProductInfoParmaeter() {

        String channelId = "210002";
        String productId = "10002";
        long timestamp = 1525762709000L;
        String transactionId = "725396974136597435435";

        QuerySingleProductInfoParameter parmaeter =
                new QuerySingleProductInfoParameter(channelId, productId, timestamp, transactionId);

        return parmaeter;
    }

    private QueryRegionProductInfo getQueryRegionProductInfo() {
        String channelId = "210002";
        long timestamp = 1525762709000L;
        String transactionId = "725396974136597435435";
        QueryRegionProductInfo info = new QueryRegionProductInfo(channelId, timestamp, transactionId);
        return info;
    }

    /**
     * 处理请求结果
     *
     * @param response 接收到的http响应
     */
    @Override
    public void handleResponse(HttpResponse response) {
        System.out.println(response);
    }

    @Override
    protected String getBaseUrl() {
        return BASE_URL;
    }
}
