package org.nix.utils.http;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 基于注解查询需要执行的方法和顺序使得子类更注重
 * 测试方法的书写
 *
 * @author zhangpei
 * @version 1.0
 * @date 2018/7/2
 */
public abstract class AbstractAnnotationInterfaceRequestProcessing extends AbstractRequestProcessing {

    public AbstractAnnotationInterfaceRequestProcessing() {
        super();
    }

    public AbstractAnnotationInterfaceRequestProcessing(AbstractProxyFactory proxy) {
        super(proxy);
    }

    /**
     * 设置允许方法逻辑
     *
     * @return
     */
    @Override
    protected List<Method> findRunMethod() {

        Class classzz = this.getClass();
        Method[] methods = classzz.getMethods();
        List<Method> runMethod = new ArrayList<>(methods.length);

        for (Method method : methods) {
            Annotation test = method.getAnnotation(Test.class);
            // 含有这个注解且注解run参数为true才被接受
            if (test != null && ((Test) test).run()) {
                runMethod.add(method);
            }
        }
        // 对方法进行排序
        rankMethodRunTime(runMethod);
        return runMethod;
    }

    /**
     * 对方法进行重排序,按权重大小进行排序
     * @param runMethod 需要排序的方法
     */
    private void rankMethodRunTime(List<Method> runMethod){
        Collections.sort(runMethod, new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                Annotation testO1 = o1.getAnnotation(Test.class);
                Annotation testO2 = o2.getAnnotation(Test.class);
                return  -(((Test) testO1).weights() - ((Test) testO2).weights());
            }
        });
    }
}
