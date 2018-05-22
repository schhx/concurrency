package org.schhx.concurrency.demo;

import lombok.extern.slf4j.Slf4j;
import org.schhx.concurrency.anno.NotThreadSafe;

/**
 * @author shanchao
 * @date 2018-05-21
 */
@Slf4j
@NotThreadSafe
public class CountDemo extends BasicTest {

    private static int count = 0;

    @Override
    protected void operateInternal() {
        count++;
    }

    public static void main(String[] args) throws Exception {
        new CountDemo().operate();
        log.info("count: {}", count);
    }
}
