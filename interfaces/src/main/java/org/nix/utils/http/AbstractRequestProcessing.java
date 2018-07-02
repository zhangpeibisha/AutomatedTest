package org.nix.utils.http;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 抽象出客户端请求和处理测试方法的动态代理
 *
 * @author zhangpei
 * @version 1.0
 * @date 2018/6/30
 */
public abstract class AbstractRequestProcessing implements RequestProcessing {



    /**
     * 使用默认代理类
     */
    public AbstractRequestProcessing() {
        super();
    }


    /**
     * 执行测试请求方法
     * 该方法执行需要测试类没有入参，如单元测试一样，如果强行入参
     * 则抛出 IllegalAccessException 异常
     * eg： 入参异常打印 ：java.lang.IllegalArgumentException: wrong number of arguments
     * @throws InvocationTargetException 调用方法异常
     * @throws IllegalAccessException 入参异常
     */
    @Override
    public void sendRequest() throws InvocationTargetException, IllegalAccessException {
        for (Method method : findRunMethod()) {
           method.invoke(this);
        }
    }

    /**
     * 由子类自定义规则去获取需要执行的方法
     * @return 需要执行的方法
     */
    protected abstract List<Method> findRunMethod();

    /**
     * 获取到字符串中指定位子的字符串
     *
     * @param str   字符串整体
     * @param start 寻找开始位
     * @param end   寻找结束位
     * @return 指定位置的字符，如果原始字符为空，则返回空,如果开始位小于0或者结束位大于字符串长度也返回空
     */
    private String getSuffix(String str, int start, int end) {
        if (str == null || start < 0 || end > str.length()) {
            return null;
        }
        return str.substring(start,end);
    }
}
