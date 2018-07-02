package org.nix.utils.http;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 业务抽象实现类，该类负责处理调用测试接口的处理逻辑
 * 测试方法由子类自行实现
 *
 * @author zhangpei
 * @version 1.0
 * @date 2018/7/1
 */
public abstract class AbstractInterfaceRequestProcessing extends AbstractRequestProcessing {

    /**
     * 此字段设置为获取到需要发送请求的方法的后缀名字
     * 例如：定义后缀为"Test" 则 addVoteTest();方法会被sendRequest();方法
     * 捕获到并尝试向服务器发送请求。
     * <p>
     * 默认后缀 Test
     */
    protected String requestSuffix = "Test";

    /**
     * 使用默认 Test 后缀定义测试方法
     */
    public AbstractInterfaceRequestProcessing() {
        super();
    }

    /**
     * 自定义后缀类定义测试方法
     *
     * @param suffix 自定义后缀
     */
    public AbstractInterfaceRequestProcessing(String suffix) {
        super();
        this.requestSuffix = suffix;
    }

    /**
     * 寻找到要执行的方法
     *
     * @return 需要执行方法集合
     */
    @Override
    protected List<Method> findRunMethod() {
        Class classzz = this.getClass();
        // 获取到所有方法的信息
        Method[] methods = classzz.getMethods();
        // 使用list来保存需要执行的方法
        int methodCount = methods.length;
        List<Method> runMethod = new ArrayList<>(methodCount);
        // 获取到需要执行的方法
        for (Method method : methods) {
            String methodName = method.getName();
            // 如果方法名字中
            if (haveSuffix(methodName)) {
                runMethod.add(method);
            }
        }
        return runMethod;
    }

    /**
     * 判断方法名是否含有指定后缀
     *
     * @param methodName 方法名字
     * @return 如果方法名字中包含了指定请求后缀名字则返回true, 否则返回false
     */
    private boolean haveSuffix(String methodName) {
        int suffixLength = requestSuffix.length();
        int start = methodName.length() - suffixLength;
        if (start < 0) {
            return false;
        }
        return methodName.substring(start).equals(requestSuffix);
    }
}
