package org.schhx.concurrency.demo.lock;

import lombok.extern.slf4j.Slf4j;
import org.schhx.concurrency.anno.ThreadSafe;
import org.schhx.concurrency.demo.BasicTest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author shanchao
 * @date 2018-06-01
 */
@Slf4j
@ThreadSafe
public class ReentrantReadWriteLockDemo extends BasicTest {

    private static final ReadWriteLock lock = new ReentrantReadWriteLock();

    private static final Lock readLock = lock.readLock();

    private static final Lock writeLock = lock.writeLock();

    private static Map<Integer, Integer> map = new HashMap<>();

    @Override
    protected void operateInternal(int threadNum) {
        write(threadNum);
        read(threadNum);
    }

    private void write(int threadNum) {
        writeLock.lock();
        try {
            log.info("write threadNum start : {}", threadNum);
            map.put(threadNum, threadNum);
        } finally {
            writeLock.unlock();
            log.info("write threadNum end : {}", threadNum);
        }
    }

    private void read(int threadNum) {
        readLock.lock();
        try {
            log.info("read threadNum start : {}", threadNum);
            map.get(threadNum);
        } finally {
            readLock.unlock();
            log.info("read threadNum end : {}", threadNum);
        }
    }

    public static void main(String[] args) {
        BasicTest.threadTotal = 5;
        BasicTest.clientTotal = 50;
        new ReentrantReadWriteLockDemo().operate();
    }
}
