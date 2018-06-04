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
public class CountDemo1 extends BasicTest {

    private static int count = 0;

    @Override
    protected void operateInternal(int threadNum) {
        count++;
    }

    public static void main(String[] args) throws Exception {
        new CountDemo1().operate();
        log.info("count: {}", count);
    }
}
