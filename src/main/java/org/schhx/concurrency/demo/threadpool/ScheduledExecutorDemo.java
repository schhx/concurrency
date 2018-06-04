package org.schhx.concurrency.demo.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author shanchao
 * @date 2018-06-04
 */
@Slf4j
public class ScheduledExecutorDemo {

    private static final ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(2);

//    private static final ScheduledExecutorService threadPool = new ScheduledThreadPoolExecutor(2,
//            new ThreadFactoryBuilder().setNameFormat("schedule-pool-%d").build());


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int threadNum = i;
            threadPool.schedule(() -> {
                log.info("execute {}", threadNum);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }

            }, 1, TimeUnit.SECONDS);
            log.info("schedule {}", threadNum);
        }
        threadPool.shutdown();

    }
}
