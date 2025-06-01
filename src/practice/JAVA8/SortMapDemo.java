package practice.JAVA8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortMapDemo {

    public static void main(String[] args) {

        Map<Integer,String> map = new HashMap<>();
        map.put(1,"One");
        map.put(2,"Two");
        map.put(3,"Three");
        map.put(4,"Four");
        map.put(5,"Five");
        map.put(6,"Six");

        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);




//        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getSalary))).forEach(System.out::println);
    }
}
