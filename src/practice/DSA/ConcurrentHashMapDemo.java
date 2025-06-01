package practice.DSA;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) throws InterruptedException {
        Map<Integer, Integer> map = new ConcurrentHashMap<>();

        Runnable writer = () ->{

            for (int i = 0; i < 100; i++) {
                System.out.println("writing");
                map.put(i, i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable reader = () -> {
//            for (Map.Entry<Integer,Integer> entry : map.entrySet()){
//                System.out.println(entry.getKey()+" - "+ entry.getValue());
//            }
            map.entrySet().parallelStream().forEach((es)->{
                System.out.println(es.getValue());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        };

        Thread writerThread = new Thread(writer);
        Thread readerThread = new Thread(reader);

        writerThread.start();
        readerThread.start();


    }
}
