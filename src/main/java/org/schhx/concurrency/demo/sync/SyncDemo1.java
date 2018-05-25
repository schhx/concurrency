package org.schhx.concurrency.demo.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author shanchao
 * @date 2018-05-22
 */
@Slf4j
public class SyncDemo1 {

    public void test1(int j) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 - {} - {}", j, i);
            }
        }
    }

    public synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test2 - {} - {}", j, i);
        }
    }

    public static void main(String[] args) {
        SyncDemo1 syncDemo1 = new SyncDemo1();
        SyncDemo1 syncDemo2 = new SyncDemo1();
        ExecutorService executorService = Executors.newCachedThreadPool();

//        executorService.submit(() -> {
//            syncDemo1.test1(1);
//        });
//        executorService.submit(() -> {
//            syncDemo1.test1(2);
//        });
//        executorService.submit(() -> {
//            syncDemo2.test1(3);
//        });

        executorService.submit(() -> {
            syncDemo1.test2(1);
        });
        executorService.submit(() -> {
            syncDemo1.test2(2);
        });
        executorService.submit(() -> {
            syncDemo2.test2(3);
        });
    }
}
