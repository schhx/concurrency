package org.schhx.concurrency.demo.aqs;

import lombok.extern.slf4j.Slf4j;
import org.schhx.concurrency.demo.BasicTest;

import java.util.concurrent.CyclicBarrier;

/**
 * @author shanchao
 * @date 2018-06-01
 */
@Slf4j
public class CyclicBarrierDemo2 extends BasicTest {

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
        log.info("================================");
    });

    @Override
    protected void operateInternal(int threadNum) {
        log.info("thread start : {}", threadNum);
        try {
            cyclicBarrier.await();
        } catch (Exception e){

        }
        log.info("thread end : {}", threadNum);
    }

    public static void main(String[] args) {
        BasicTest.clientTotal = 50;
        BasicTest.threadTotal = 5;
        new CyclicBarrierDemo2().operate();
    }
}
