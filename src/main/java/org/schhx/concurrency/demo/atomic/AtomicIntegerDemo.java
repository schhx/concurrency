package org.schhx.concurrency.demo.atomic;

import lombok.extern.slf4j.Slf4j;
import org.schhx.concurrency.anno.ThreadSafe;
import org.schhx.concurrency.demo.BasicTest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shanchao
 * @date 2018-05-21
 */
@Slf4j
@ThreadSafe
public class AtomicIntegerDemo extends BasicTest {

    private static AtomicInteger count = new AtomicInteger();

    @Override
    protected void operateInternal(int threadNum) {
        count.incrementAndGet();
    }

    public static void main(String[] args) {
        new AtomicIntegerDemo().operate();
        log.info("count: {}", count.get());
    }
}
