package org.nix.utils.http;

import java.lang.reflect.InvocationTargetException;

/**
 * 对http的请求和处理接口方法定义
 *
 * 一个完整的http请求包含了发出请求和接受响应两个动作
 * 因此将这两个行为定义为一个接口，满足http请求的子类应当满足这
 * 两个行为的定义
 * @author zhangpei
 * @version 1.0
 * @date 2018/6/30
 */
public interface RequestProcessing {
    /**
     * 执行所有测试方法
     * @throws InvocationTargetException 反射异常
     * @throws IllegalAccessException 反射中参数注入异常
     */
    void sendRequest() throws InvocationTargetException, IllegalAccessException;

}
