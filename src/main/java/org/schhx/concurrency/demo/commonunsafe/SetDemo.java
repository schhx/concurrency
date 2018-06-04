package org.schhx.concurrency.demo.commonunsafe;

import lombok.extern.slf4j.Slf4j;
import org.schhx.concurrency.anno.NotThreadSafe;
import org.schhx.concurrency.demo.BasicTest;

import java.util.*;

/**
 * HashSet、LinkedHashSet、TreeSet都是线程不安全的
 *
 * @author shanchao
 * @date 2018-05-28
 */
@Slf4j
@NotThreadSafe
public class SetDemo extends BasicTest {

//    private static Set<String> set = new HashSet<>();
//    private static Set<String> set = new LinkedHashSet<>();
    private static Set<String> set = new TreeSet<>();

    @Override
    protected void operateInternal(int threadNum) {
        set.add(UUID.randomUUID().toString());
    }


    public static void main(String[] args) {
        new SetDemo().operate();
        log.info("size: {}", set.size());
    }
}
