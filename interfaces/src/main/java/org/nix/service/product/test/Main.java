package org.nix.service.product.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/7/3
 */
public class Main {

    public static void main(String[] args) {
        int threadNumber = 200;
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < threadNumber; i++) {
            ProductInfoThreadTest threadTest = new ProductInfoThreadTest();
            cachedThreadPool.execute(threadTest);
        }
    }

}
