package org.nix.utils.http;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/7/2
 */
public abstract class AbstractSystemTest extends AbstractAnnotationInterfaceRequestProcessing implements HttpClient{

    @Override
    public HttpResponse sendHttpRequest(String url, Object parameter) {
        HttpResponse response = null;
        response = AbstractHttpClient.sendHttpRequest(url, parameter, response);
        handleResponse(response);
        return response;
    }

    /**
     * 自定义请求
     *
     * @param sonUrl 子路径
     * @param json   请求json字符串
     */
    protected void httpRequest(String sonUrl, String json) {
        ((AbstractSystemTest)proxy.getProxyInstance()).sendHttpRequest(getBaseUrl() + sonUrl, json);
    }

    /**
     * 客户端提供基础访问路径
     * @return 返回基础访问路径
     */
    protected abstract String getBaseUrl();
}
