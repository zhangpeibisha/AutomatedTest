package org.nix.utils.http;

import org.nix.utils.json.JacksonUtil;

import java.io.IOException;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/7/2
 */
public abstract class AbstractHttpClient implements HttpClient {

    @Override
    public void sendHttpRequest(String url, Object parameter) {
        HttpResponse response = null;
        response = sendHttpRequest(url, parameter, response);
        handleResponse(response);
    }

    static HttpResponse sendHttpRequest(String url, Object parameter, HttpResponse response) {
        if (parameter instanceof String){
            response = HttpUtil.doPostJson(url,parameter.toString());
        }else{
            try {
                String json = JacksonUtil.bean2Json(parameter);
                response = HttpUtil.doPostJson(url,json);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return response;
    }
}
