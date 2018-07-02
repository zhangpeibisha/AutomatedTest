package org.nix.utils.http;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 抽象代理类给予cglib实现
 * @author zhangpei
 * @version 1.0
 * @date 2018/7/1
 */
public abstract class AbstractProxyFactory {
    /**
     * 需要代理的对象
     */
    private Object target;

    public AbstractProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 给需要代理的对象创建一个代理对象
     * @return 代理对象
     */
    public Object getProxyInstance(){
        //1.工具类
        Enhancer en = new Enhancer();
        //2.设置父类
        en.setSuperclass(target.getClass());
        //3.设置回调函数
        en.setCallback(new MethodInterceptor(){
        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            preHandler(method,args);
            //执行目标对象的方法
            Object returnValue = method.invoke(target, args);
            postHandler(returnValue);
            return returnValue;
            }
        });
        //4.创建子类(代理对象)
        return en.create();
    }

    /**
     * 代理方法前置执行方法
     * @param args 入参
     * @param method 执行方法
     */
    public abstract void preHandler(Method method ,Object[] args);

    /**
     * 代理方法后置执行
     * @param args 出参
     */
    public abstract void postHandler(Object args);
}
