package org.schhx.concurrency.demo.commonunsafe;

import lombok.extern.slf4j.Slf4j;
import org.schhx.concurrency.anno.NotThreadSafe;
import org.schhx.concurrency.demo.BasicTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ArrayList、LinkedList都是线程不安全的
 *
 * @author shanchao
 * @date 2018-05-28
 */
@Slf4j
@NotThreadSafe
public class ListDemo extends BasicTest {

    //    private static List<Integer> list = new ArrayList<>();
    private static List<Integer> list = new LinkedList<>();

    @Override
    protected void operateInternal(int threadNum) {
        list.add(1);
    }


    public static void main(String[] args) {
        new ListDemo().operate();
        log.info("size: {}", list.size());
    }
}
