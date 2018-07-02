package org.nix.utils.http;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于标注执行方法的注解
 * @author zhangpei
 * @version 1.0
 * @date 2018/7/2
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
    /**
     * 该属性标注出来为了设置方法的执行权重
     * 权重越高则越优先执行，默认为最低权重
     * @return 方法权重
     */
    int weights() default 0;

    /**
     * 该属性标注出方法是否执行，默认为true则表示执行
     * 只有使用者明确说明不执行才不执行
     * @return 是否执行
     */
    boolean run() default true;

}
