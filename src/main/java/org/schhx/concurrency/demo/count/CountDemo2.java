package org.schhx.concurrency.demo.count;

import lombok.extern.slf4j.Slf4j;
import org.schhx.concurrency.anno.NotThreadSafe;
import org.schhx.concurrency.demo.BasicTest;

/**
 * @author shanchao
 * @date 2018-05-21
 */
@Slf4j
@NotThreadSafe
public class CountDemo2 extends BasicTest {

    private volatile static int count = 0;

    @Override
    protected void operateInternal() {
        count++;
    }

    public static void main(String[] args) throws Exception {
        new CountDemo2().operate();
        log.info("count: {}", count);
    }
}
