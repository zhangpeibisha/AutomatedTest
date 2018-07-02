package org.nix.utils.http;

/**
 * 抽象客户端请求
 * 暂时为空，待抽象行为出来，若最后不需要
 * 则删除该接口
 * @author zhangpei
 * @version 1.0
 * @date 2018/7/1
 */
public interface HttpClient {

    /**
     * 接收到http响应
     * @param response 接收到的http响应
     */
    void handleResponse(HttpResponse response);

    /**
     * 发送http请求
     * @param url 请求路径
     * @param parameter 请求参数
     * @return 请求结果
     */
    HttpResponse sendHttpRequest(String url, Object parameter);

}
