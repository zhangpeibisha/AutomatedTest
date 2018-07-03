package org.nix.utils.http;

/**
 * 重写http请求方法
 * @author zhangpei
 * @version 1.0
 * @date 2018/7/3
 */
public abstract class AbstractSystemCXFTest extends AbstractSystemTest{

    @Override
    protected HttpResponse sendHttpRequest(String url, Object parameter, HttpResponse response) {
        return null;
    }
}
