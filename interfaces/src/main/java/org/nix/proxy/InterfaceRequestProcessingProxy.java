package org.nix.proxy;

import org.nix.utils.http.AbstractProxyFactory;

/**
 * 对接口测试的代理类
 * 争对代理类方法的执行前后计入业务逻辑由用户自定义
 *
 * @author zhangpei
 * @version 1.0
 * @date 2018/7/1
 */
public class InterfaceRequestProcessingProxy extends AbstractProxyFactory {

    public InterfaceRequestProcessingProxy(Object target) {
        super(target);
    }

    @Override
    public void preHandler(Object[] args) {
        System.out.println("=======================================");
        System.out.println("入参 === >");
        System.out.println("[");
        for (Object o : args) {
            System.out.println(o.toString());
        }
        System.out.println("]");
    }

    @Override
    public void postHandler(Object args) {
        System.out.println("出参 === >");
        System.out.println("[" + args + "]");
        System.out.println("=======================================");
    }


}
