package org.schhx.concurrency.demo.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author shanchao
 * @date 2018-06-04
 */
@Slf4j
public class BlockingQueueDemo {

    public static void main(String[] args) throws Exception {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(5);

        new Thread(()->{
            queue.poll();
        }).start();

        new Thread(()->{

        }).start();

    }
}
