package org.schhx.concurrency.demo.atomic;

import lombok.extern.slf4j.Slf4j;
import org.schhx.concurrency.anno.ThreadSafe;
import org.schhx.concurrency.demo.BasicTest;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author shanchao
 * @date 2018-05-21
 */
@Slf4j
@ThreadSafe
public class AtomicDemo4 extends BasicTest {

    private static AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    @Override
    protected void operateInternal() {
        if(atomicBoolean.compareAndSet(false, true)) {
            log.info("do something");
        }
    }

    public static void main(String[] args) {
        new AtomicDemo4().operate();
    }
}