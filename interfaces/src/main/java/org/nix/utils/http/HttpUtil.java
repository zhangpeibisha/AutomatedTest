package org.nix.utils.http;


import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.nix.service.product.parmateter.QueryProductInfoParameter;
import org.nix.utils.json.JacksonUtil;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/7/1
 */
public class HttpUtil {

    private static final int SUCCESS_CODE = 200;

    public static HttpResponse doGet(String url, Map<String, String> param) {

        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpResponse myResponse = null;
        String resultString = "";
        int status;
        CloseableHttpResponse response = null;
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key));
                }
            }
            URI uri = builder.build();
            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);
            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            status = response.getStatusLine().getStatusCode();
            myResponse = new HttpResponse(status,resultString);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return myResponse;
    }

    public static HttpResponse doGet(String url) {
        return doGet(url, null);
    }

    public static HttpResponse doPost(String url, Map<String, String> param) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        HttpResponse myResponse = null;
        int status;
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建参数列表
            if (param != null) {
                List<NameValuePair> paramList = new ArrayList<>();
                for (String key : param.keySet()) {
                    paramList.add(new BasicNameValuePair(key, param.get(key)));
                }
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList,"utf-8");
                httpPost.setEntity(entity);
            }
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
            status = response.getStatusLine().getStatusCode();
            myResponse = new HttpResponse(status,resultString);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return myResponse;
    }

    public static HttpResponse doPost(String url) {
        return doPost(url, null);
    }

//    public static String doPostJson(String url, String json) {
//        // 创建Httpclient对象
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        CloseableHttpResponse response = null;
//        String resultString = "";
//        try {
//            // 创建Http Post请求
//            HttpPost httpPost = new HttpPost(url);
//            // 创建请求内容
//            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
//            httpPost.setEntity(entity);
//            // 执行http请求
//            response = httpClient.execute(httpPost);
//            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                response.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return resultString;
//    }

    public static HttpResponse doPostJson(String url, String json){
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        HttpResponse myResponse = null;
        String resultString = "";
        int status;
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建请求内容
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
            status = response.getStatusLine().getStatusCode();
            myResponse = new HttpResponse(status,resultString);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return myResponse;
    }

    public static void main(String[] args) throws IOException {
        String url = "http://fstestmall.pizzahut.com.cn/Flashsale/api/QueryProductInfo";
        String json = JacksonUtil.bean2Json(getQueryProductInfoParameter());
        System.out.println(json);
        HttpResponse result = HttpUtil.doPostJson(url,json);
        System.out.println(result);
    }

    /**
     * 设置秒杀品库存查询
     *
     * @return 参数实体
     */
    private static QueryProductInfoParameter getQueryProductInfoParameter() {
        String channelId = "210002";
        List<String> productIds = new ArrayList<>();
        productIds.add("10005");
        productIds.add("10003");
        long timestamp = 1525762709000L;
        String transactionId = "725396974136597435435";
        QueryProductInfoParameter parameter =
                new QueryProductInfoParameter(channelId, productIds, timestamp, transactionId);
        return parameter;
    }
}
