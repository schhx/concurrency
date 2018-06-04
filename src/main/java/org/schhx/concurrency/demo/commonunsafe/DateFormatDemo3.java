package org.schhx.concurrency.demo.commonunsafe;

import lombok.extern.slf4j.Slf4j;
import org.schhx.concurrency.anno.NotThreadSafe;
import org.schhx.concurrency.demo.BasicTest;

import java.text.SimpleDateFormat;

/**
 * @author shanchao
 * @date 2018-05-28
 */
@Slf4j
@NotThreadSafe
public class DateFormatDemo3 extends BasicTest {

    @Override
    protected void operateInternal(int threadNum) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            simpleDateFormat.parse("2018-01-01");
        } catch (Exception e) {
            log.error("parse exception", e);
        }
    }


    public static void main(String[] args) {
        new DateFormatDemo3().operate();
    }
}
