package org.schhx.concurrency.demo.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author shanchao
 * @date 2018-06-04
 */
@Slf4j
public class SemaphoreDemo2 {

    private static final int clientTotal = 10;

    private static final int threadTotal = 2;

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(threadTotal);

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < clientTotal; i++) {
            final int threadNum = i;
            executorService.submit(() -> {
                try {
                    semaphore.acquire(2);
                    log.info("thread {}", threadNum);
                    Thread.sleep(1000);
                } catch (Exception e) {

                } finally {
                    semaphore.release(2);
                }
            });
        }
        executorService.shutdown();
    }
}
