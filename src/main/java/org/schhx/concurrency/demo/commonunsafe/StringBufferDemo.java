package org.schhx.concurrency.demo.commonunsafe;

import lombok.extern.slf4j.Slf4j;
import org.schhx.concurrency.anno.ThreadSafe;
import org.schhx.concurrency.demo.BasicTest;

/**
 * @author shanchao
 * @date 2018-05-29
 */
@Slf4j
@ThreadSafe
public class StringBufferDemo extends BasicTest {

    private static StringBuffer stringBuffer = new StringBuffer();


    @Override
    protected void operateInternal(int threadNum) {
        stringBuffer.append("1");
    }

    public static void main(String[] args) {
        new StringBufferDemo().operate();
        log.info("length: {}", stringBuffer.length());
    }
}
