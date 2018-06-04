package org.schhx.concurrency.demo.lock;

import lombok.extern.slf4j.Slf4j;
import org.schhx.concurrency.anno.ThreadSafe;
import org.schhx.concurrency.demo.BasicTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shanchao
 * @date 2018-06-01
 */
@Slf4j
@ThreadSafe
public class ReentrantLockDemo extends BasicTest {

    private static final Lock lock = new ReentrantLock();

    private static int count = 0;

    @Override
    protected void operateInternal(int threadNum) {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        new ReentrantLockDemo().operate();
        log.info("count : {}", count);
    }
}
