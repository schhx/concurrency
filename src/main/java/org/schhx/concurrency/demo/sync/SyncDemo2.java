package org.schhx.concurrency.demo.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author shanchao
 * @date 2018-05-22
 */
@Slf4j
public class SyncDemo2 {

    public void test1(int j) {
        synchronized (SyncDemo2.class) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 - {} - {}", j, i);
            }
        }
    }

    public synchronized static void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test2 - {} - {}", j, i);
        }
    }

    public static void main(String[] args) {
        SyncDemo2 syncDemo1 = new SyncDemo2();
        SyncDemo2 syncDemo2 = new SyncDemo2();
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
            SyncDemo2.test2(1);
        });
        executorService.submit(() -> {
            SyncDemo2.test2(2);
        });
        executorService.submit(() -> {
            SyncDemo2.test2(3);
        });
    }
}
