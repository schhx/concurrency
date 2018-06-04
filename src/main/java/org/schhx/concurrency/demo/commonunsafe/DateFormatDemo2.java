package org.schhx.concurrency.demo.commonunsafe;

import lombok.extern.slf4j.Slf4j;
import org.schhx.concurrency.anno.ThreadSafe;
import org.schhx.concurrency.demo.BasicTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @author shanchao
 * @date 2018-05-28
 */
@Slf4j
@ThreadSafe
public class DateFormatDemo2 extends BasicTest {

    private static ThreadLocal<DateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    @Override
    protected void operateInternal(int threadNum) {
        try {
            threadLocal.get().parse("2018-01-01");
        } catch (Exception e) {
            log.error("parse exception", e);
        }
    }


    public static void main(String[] args) {
        new DateFormatDemo2().operate();
    }
}
