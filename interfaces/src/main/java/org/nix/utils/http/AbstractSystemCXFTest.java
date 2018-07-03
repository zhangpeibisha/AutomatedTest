package org.nix.utils.http;

import java.io.IOException;

/**
 * 重写http请求方法
 *
 * @author zhangpei
 * @version 1.0
 * @date 2018/7/3
 */
public abstract class AbstractSystemCXFTest extends AbstractSystemTest {

    @Override
    protected HttpResponse sendHttpRequest(String url, Object parameter, HttpResponse response) {
        response = null;
        try {
            Object result = WebClientUtil.postJson(url, parameter);
            if (result == null){
                response.setContent(null);
                response.setStatus(500);
            }
            response.setContent(result);
            response.setStatus(200);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
