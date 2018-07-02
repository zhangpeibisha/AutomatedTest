package org.nix.utils.http;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/7/2
 */
public class HttpResponse {

    private int status;

    private Object content;

    public HttpResponse(int status, Object content) {
        this.status = status;
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "HttpResponse{" +
                "status=" + status +
                ", content=" + content +
                '}';
    }
}
