package org.schhx.concurrency.demo.commonunsafe;

import lombok.extern.slf4j.Slf4j;
import org.schhx.concurrency.anno.NotThreadSafe;
import org.schhx.concurrency.demo.BasicTest;

import java.util.*;

/**
 * HashMap、LinkedHashMap、TreeMap都是线程不安全的
 *
 * @author shanchao
 * @date 2018-05-28
 */
@Slf4j
@NotThreadSafe
public class MapDemo extends BasicTest {

//    private static Map<String, String> map = new HashMap<>();
//    private static Map<String, String> map = new LinkedHashMap<>();
    private static Map<String, String> map = new TreeMap<>();

    @Override
    protected void operateInternal(int threadNum) {
        map.put(UUID.randomUUID().toString(), "");
    }


    public static void main(String[] args) {
        new MapDemo().operate();
        log.info("size: {}", map.size());
    }
}
