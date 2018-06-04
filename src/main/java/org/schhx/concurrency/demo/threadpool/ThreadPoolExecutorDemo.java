package org.schhx.concurrency.demo.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author shanchao
 * @date 2018-06-04
 */
@Slf4j
public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ExecutorService threadPool = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(200), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 10; i++) {
            int threadNum = i;
            threadPool.execute(() -> {
                log.info("{}", threadNum);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
            });
        }
        threadPool.shutdown();
    }
}
