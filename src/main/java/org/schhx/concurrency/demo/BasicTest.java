package org.schhx.concurrency.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author shanchao
 * @date 2018-05-21
 */
@Slf4j
public abstract class BasicTest {

    protected static int clientTotal = 5000;

    protected static int threadTotal = 50;

    protected void operate() {
        try {
            ExecutorService executorService = Executors.newCachedThreadPool();
            final Semaphore semaphore = new Semaphore(threadTotal);
            final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
            for (int i = 0; i < clientTotal; i++) {
                final int threadNum = i;
                executorService.execute(() -> {
                    try {
                        semaphore.acquire();
                        operateInternal(threadNum);
                        semaphore.release();
                    } catch (Exception e) {
                        log.error("exception", e);
                    }
                    countDownLatch.countDown();
                });
            }
            countDownLatch.await();
            executorService.shutdown();
        } catch (Exception e) {
            log.error("exception", e);
        }
    }

    /**
     * 具体执行的方法
     *
     * @param threadNum
     */
    protected abstract void operateInternal(int threadNum);
}
