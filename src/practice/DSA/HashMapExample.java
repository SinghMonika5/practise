package practice.DSA;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();

        Runnable writer = () -> {
            for (int i = 0; i < 10000; i++) {
                map.put(i, i);
            }
        };

        Runnable reader = () -> {
            for (Map.Entry<Integer,Integer> entry : map.entrySet()){
                System.out.println(entry.getKey()+" - "+ entry.getValue());
            }
        };

        Thread writerThread = new Thread(writer);
        Thread readerThread = new Thread(reader);

        writerThread.start();
        readerThread.start();
    }
}
