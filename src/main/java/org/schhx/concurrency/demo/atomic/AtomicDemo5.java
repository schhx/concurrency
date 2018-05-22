package org.schhx.concurrency.demo.atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author shanchao
 * @date 2018-05-22
 */
@Slf4j
public class AtomicDemo5 {

    private static AtomicReference<Integer> atomicReference = new AtomicReference<>(0);

    public static void main(String[] args) {
        atomicReference.compareAndSet(0, 2);
        atomicReference.compareAndSet(1, 3);
        atomicReference.compareAndSet(2, 4);
        atomicReference.compareAndSet(3, 5);

        log.info("value - {}", atomicReference.get());
    }
}
