package map;

import java.util.concurrent.ConcurrentSkipListMap;

public class concurrentSkipListMap {
    public static void main(String[] args) {
        ConcurrentSkipListMap<String, Integer> skipListMap = new ConcurrentSkipListMap<>();

        // 添加键值对
        skipListMap.put("one", 1);
        skipListMap.put("three", 3);
        skipListMap.put("five", 5);
        skipListMap.put("two", 2);
        skipListMap.put("four", 4);
        skipListMap.put("ff", 8);
        skipListMap.put("ffe", 10);

        for (String key : skipListMap.keySet()) {
            System.out.println(key);
        }

        System.out.println("-------------------");

        for (Integer value : skipListMap.values()) {
            System.out.println(value);
        }
    }
}
