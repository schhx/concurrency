package org.schhx.concurrency.demo.commonunsafe;

import lombok.extern.slf4j.Slf4j;
import org.schhx.concurrency.anno.NotThreadSafe;
import org.schhx.concurrency.demo.BasicTest;

/**
 * @author shanchao
 * @date 2018-05-29
 */
@Slf4j
@NotThreadSafe
public class StringBuilderDemo extends BasicTest {

    private static StringBuilder stringBuilder = new StringBuilder();


    @Override
    protected void operateInternal(int threadNum) {
        stringBuilder.append("1");
    }

    public static void main(String[] args) {
        new StringBuilderDemo().operate();
        log.info("length: {}", stringBuilder.length());
    }
}
