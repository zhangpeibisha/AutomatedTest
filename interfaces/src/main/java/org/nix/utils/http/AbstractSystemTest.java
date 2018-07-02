package org.nix.utils.http;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/7/2
 */
public abstract class AbstractSystemTest extends AbstractAnnotationInterfaceRequestProcessing implements HttpClient{

    @Override
    public void sendHttpRequest(String url, Object parameter) {
        HttpResponse response = null;
        response = AbstractHttpClient.sendHttpRequest(url, parameter, response);
        handleResponse(response);
    }
    
}
