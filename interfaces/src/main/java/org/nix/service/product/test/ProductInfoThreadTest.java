package org.nix.service.product.test;

import org.nix.service.product.info.ProductInfoTest;

import java.lang.reflect.InvocationTargetException;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/7/3
 */
public class ProductInfoThreadTest implements Runnable{

    private ProductInfoTest productInfoTest = new ProductInfoTest();

    @Override
    public void run() {
        try {
            productInfoTest.sendRequest();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
