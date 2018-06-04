package org.schhx.concurrency.demo.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author shanchao
 * @date 2018-06-04
 */
@Slf4j
public class FutureTaskDemo {

    public static void main(String[] args) throws Exception {
        FutureTask<String> futureTask = new FutureTask<String>(() -> {
            log.info("future task");
            Thread.sleep(5000);
            return "Done";
        });

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(futureTask);
        log.info("main ...");
        Thread.sleep(2000);
        String result = futureTask.get();
        log.info("result {}", result);
        executorService.shutdown();
    }
}
