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
public class AtomicDemo1 extends BasicTest {

    private static AtomicInteger count = new AtomicInteger();

    @Override
    protected void operateInternal() {
        count.incrementAndGet();
    }

    public static void main(String[] args) {
        new AtomicDemo1().operate();
        log.info("count: {}", count.get());
    }
}
