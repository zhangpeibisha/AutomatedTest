package org.nix.exceptions;

/**
 * excel业务操作异常
 * @author zhangpei
 * @version 1.0
 * @date 2018/6/29
 */
public class ExcelException extends RuntimeException{
   private String message;

    public ExcelException(String message) {
        this.message = message;
    }

    public ExcelException() {
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
        return "ExcelException{" +
                "message='" + message + '\'' +
                '}';
    }
}
