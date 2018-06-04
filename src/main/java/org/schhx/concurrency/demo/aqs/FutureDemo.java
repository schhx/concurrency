package org.schhx.concurrency.demo.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author shanchao
 * @date 2018-06-04
 */
@Slf4j
public class FutureDemo {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(() -> {
            log.info("callable ...");
            Thread.sleep(5000);
            return "Done";
        });

        log.info("main ...");
        Thread.sleep(2000);
        String result = future.get();
        log.info("result {}", result);
        executorService.shutdown();
    }
}
