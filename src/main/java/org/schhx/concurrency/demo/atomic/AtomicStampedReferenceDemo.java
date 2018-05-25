package org.schhx.concurrency.demo.atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * AtomicStampedReference通过版本号解决CAS的ABA问题
 *
 * @author shanchao
 * @date 2018-05-22
 */
@Slf4j
public class AtomicStampedReferenceDemo {

    private static AtomicReference<Integer> atomicReference = new AtomicReference<>(0);

    private static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(0, 1);

    public static void main(String[] args) throws Exception {
        Thread thread1 = new Thread(() -> {
            atomicReference.compareAndSet(0, 1);
            atomicReference.compareAndSet(1, 0);
        });

        Thread thread2 = new Thread(() -> {
            try {
                // 让thread1先执行完
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e){

            }
            boolean result = atomicReference.compareAndSet(0, 2);
            log.info("AtomicReference ABA Success- {}", result);
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();



        Thread thread3 = new Thread(() -> {
            try {
                // 让thread4先取的stamp
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e){

            }
            atomicStampedReference.compareAndSet(0, 1, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            atomicStampedReference.compareAndSet(1, 0, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
        });

        Thread thread4 = new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            try {
                // 让thread3先执行完
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e){

            }
            boolean result = atomicStampedReference.compareAndSet(0, 2, stamp, stamp + 1);
            log.info("AtomicStampedReference ABA Success- {}", result);
        });

        thread3.start();
        thread4.start();

        thread3.join();
        thread4.join();
    }
}
