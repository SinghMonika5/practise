package practice.JAVA8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEachDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        list.add("Six");

       list.stream().forEach(s-> System.out.println(s));
        list.stream().filter((s)->s.startsWith("F")).forEach(s-> System.out.println(s));

        Map<Integer,String> map = new HashMap<>();
        map.put(1,"One");
        map.put(2,"Two");
        map.put(3,"Three");
        map.put(4,"Four");
        map.put(5,"Five");
        map.put(6,"Six");

        //map.forEach((k,v)-> System.out.println(k+"|"+v));
       // map.entrySet().stream().forEach(obj-> System.out.println(obj));
        map.entrySet().stream().filter(k->k.getKey()==1).forEach((e)-> System.out.println(e.getValue()));
    }
}
