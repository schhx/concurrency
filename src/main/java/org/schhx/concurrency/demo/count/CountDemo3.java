package org.schhx.concurrency.demo.count;

import lombok.extern.slf4j.Slf4j;
import org.schhx.concurrency.anno.ThreadSafe;
import org.schhx.concurrency.demo.BasicTest;

/**
 * @author shanchao
 * @date 2018-05-21
 */
@Slf4j
@ThreadSafe
public class CountDemo3 extends BasicTest {

    private static int count = 0;

    @Override
    protected synchronized void operateInternal() {
        count++;
    }

    public static void main(String[] args) throws Exception {
        new CountDemo3().operate();
        log.info("count: {}", count);
    }
}
