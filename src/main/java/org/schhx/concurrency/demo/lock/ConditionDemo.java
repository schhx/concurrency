package org.schhx.concurrency.demo.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shanchao
 * @date 2018-06-01
 */
@Slf4j
public class ConditionDemo {

    private static LinkedList<String> list = new LinkedList<>();

    private final static int MAX_SIZE = 10;

    private static Lock lock = new ReentrantLock();

    private static Condition consumerCondition = lock.newCondition();

    private static Condition producerCondition = lock.newCondition();

    public String get() {
        lock.lock();
        try {
            if (list.isEmpty()) {
                consumerCondition.await();
            }
            String value = list.pop();
            log.info("消费了1个，总共有{}个", list.size());
            producerCondition.signalAll();
            return value;
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
        return null;
    }

    public void put(String s) {
        lock.lock();
        try {
            if (list.size() >= MAX_SIZE) {
                producerCondition.await();
            }
            list.push(s);
            log.info("生产了1个，总共有{}个", list.size());
            consumerCondition.signalAll();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        ConditionDemo conditionDemo = new ConditionDemo();
        Runnable producer = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {

                    }
                    conditionDemo.put("");
                }
            }
        };

        Runnable consumer = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {

                    }
                    conditionDemo.get();
                }
            }
        };

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
