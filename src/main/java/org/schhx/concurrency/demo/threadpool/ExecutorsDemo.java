package org.schhx.concurrency.demo.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author shanchao
 * @date 2018-06-04
 */
@Slf4j
public class ExecutorsDemo {

        private static final ExecutorService threadPool = Executors.newFixedThreadPool(2);
//    private static final ExecutorService threadPool = Executors.newCachedThreadPool();
//    private static final ExecutorService threadPool = Executors.newScheduledThreadPool(2);
//    private static final ExecutorService threadPool = Executors.newSingleThreadExecutor();


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int threadNum = i;
            threadPool.execute(() -> {
                log.info("{}", threadNum);
            });
        }
        threadPool.shutdown();

    }
}
