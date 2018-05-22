package org.schhx.concurrency.demo.atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author shanchao
 * @date 2018-05-22
 */
@Slf4j
public class AtomicDemo6 {

    private static AtomicIntegerFieldUpdater<AtomicDemo6> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicDemo6.class, "value");

    private volatile int value = 0;

    public static void main(String[] args) {
        AtomicDemo6 atomicDemo6 = new AtomicDemo6();
        updater.compareAndSet(atomicDemo6, 0, 2);
        updater.compareAndSet(atomicDemo6, 1, 3);
        updater.compareAndSet(atomicDemo6, 2, 4);
        updater.compareAndSet(atomicDemo6, 3, 5);

        log.info("value - {}", updater.get(atomicDemo6));
    }
}
