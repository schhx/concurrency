package org.schhx.concurrency.demo.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author shanchao
 * @date 2018-06-01
 */
@Slf4j
public class CountDownLatchDemo2 {

    private static int clientCount = 10;

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(clientCount);
        for (int i = 0; i < clientCount; i++) {
            final int num = i;
            executorService.submit(() -> {
                task(num);
                countDownLatch.countDown();
            });
        }

        countDownLatch.await(1000, TimeUnit.MILLISECONDS);
        log.info("all tasks are finished");
        executorService.shutdown();

    }

    private static void task(int num) {
        try {
            Thread.sleep(num * 200);
            log.info("task {} is finished", num);
        } catch (Exception e) {

        }
    }
}
