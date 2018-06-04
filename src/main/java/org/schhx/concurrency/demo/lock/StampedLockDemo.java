package org.schhx.concurrency.demo.lock;

import lombok.extern.slf4j.Slf4j;
import org.schhx.concurrency.demo.BasicTest;

import java.util.concurrent.locks.StampedLock;

/**
 * @author shanchao
 * @date 2018-06-04
 */
@Slf4j
public class StampedLockDemo extends BasicTest {

    private static final StampedLock lock = new StampedLock();

    private static int count = 0;

    @Override
    protected void operateInternal(int threadNum) {
        long stamp = lock.writeLock();
        try {
            count++;
        } finally {
            lock.unlock(stamp);
        }
    }


    public static void main(String[] args) {
        new StampedLockDemo().operate();
        log.info("count {}", count);
    }
}
