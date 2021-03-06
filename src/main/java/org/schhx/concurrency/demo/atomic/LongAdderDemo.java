package org.schhx.concurrency.demo.atomic;

import lombok.extern.slf4j.Slf4j;
import org.schhx.concurrency.anno.ThreadSafe;
import org.schhx.concurrency.demo.BasicTest;

import java.util.concurrent.atomic.LongAdder;

/**
 * @author shanchao
 * @date 2018-05-21
 */
@Slf4j
@ThreadSafe
public class LongAdderDemo extends BasicTest {

    private static LongAdder count = new LongAdder();

    @Override
    protected void operateInternal(int threadNum) {
        count.increment();
    }

    public static void main(String[] args) {
        new LongAdderDemo().operate();
        log.info("count: {}", count);
    }
}
