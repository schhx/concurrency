package org.schhx.concurrency.demo.atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author shanchao
 * @date 2018-05-22
 */
@Slf4j
public class AtomicIntegerFieldUpdaterDemo {

    private static AtomicIntegerFieldUpdater<AtomicIntegerFieldUpdaterDemo> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFieldUpdaterDemo.class, "value");

    private volatile int value = 0;

    public static void main(String[] args) {
        AtomicIntegerFieldUpdaterDemo atomicDemo6 = new AtomicIntegerFieldUpdaterDemo();
        updater.compareAndSet(atomicDemo6, 0, 2);
        updater.compareAndSet(atomicDemo6, 1, 3);
        updater.compareAndSet(atomicDemo6, 2, 4);
        updater.compareAndSet(atomicDemo6, 3, 5);

        log.info("value - {}", updater.get(atomicDemo6));
    }
}
