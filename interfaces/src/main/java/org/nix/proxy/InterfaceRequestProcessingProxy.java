package org.nix.proxy;

import org.nix.utils.http.AbstractProxyFactory;

import java.lang.reflect.Method;

/**
 * 对接口测试的代理类
 * 争对代理类方法的执行前后计入业务逻辑由用户自定义
 *
 * @author zhangpei
 * @version 1.0
 * @date 2018/7/1
 */
public class InterfaceRequestProcessingProxy extends AbstractProxyFactory {

    private Object target;

    private long runTime;

    public InterfaceRequestProcessingProxy(Object target) {
        super(target);
        this.target = target;
    }

    @Override
    public void preHandler(Method method ,Object[] args) {
        runTime = System.currentTimeMillis();
        System.out.println("=======================================");
        System.out.println("方法执行开始时间:" + runTime + "/s");
        System.out.println("执行方法名字 === > "+ target.getClass() + "." + method.getName());
        System.out.println("入参 === >");
        System.out.println("[");
        for (Object o : args) {
            System.out.println(o.toString());
        }
        System.out.println("]");
    }

    @Override
    public void postHandler(Object args) {
        long tempTime = System.currentTimeMillis();
        System.out.println("方法执行结束时间:" + tempTime + "/s");
        System.out.println("方法执行耗时:"+(tempTime-runTime) + "/s");
        System.out.println("出参 === >");
        System.out.println("[" + args + "]");
        System.out.println("=======================================");
    }


}
