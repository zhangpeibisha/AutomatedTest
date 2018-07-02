package org.nix.exceptions;

/**
 * 测试业务异常
 * @author zhangpei
 * @version 1.0
 * @date 2018/7/1
 */
public class InterfaceTestException extends RuntimeException{
    private String message;

    public InterfaceTestException(String message) {
        this.message = message;
    }

    public InterfaceTestException() {
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "InterfaceTestException{" +
                "message='" + message + '\'' +
                '}';
    }
}
