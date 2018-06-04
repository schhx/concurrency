package org.schhx.concurrency.demo.aqs;

import lombok.extern.slf4j.Slf4j;
import org.schhx.concurrency.demo.BasicTest;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author shanchao
 * @date 2018-06-01
 */
@Slf4j
public class CyclicBarrierDemo3 extends BasicTest {

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
        log.info("================================");
    });

    @Override
    protected void operateInternal(int threadNum) {
        log.info("thread start : {}", threadNum);
        try {
            Thread.sleep(1000);
            cyclicBarrier.await(1000, TimeUnit.MILLISECONDS);
        } catch (Exception e){
            log.error("exception " + threadNum, e);
        }
        log.info("thread end : {}", threadNum);
    }

    public static void main(String[] args) {
        BasicTest.clientTotal = 10;
        BasicTest.threadTotal = 2;
        new CyclicBarrierDemo3().operate();
    }
}
