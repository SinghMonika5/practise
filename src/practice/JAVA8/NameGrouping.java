package practice.JAVA8;

import java.util.*;
import java.util.stream.Collectors;

public class NameGrouping {
    public static void main(String[] args) {
        String[] strArr = {"Alice", "Bob","Bob", "Charlie", "David", "Eva", "Frank", "Anna"};

        Map<String, List<String>> nameGroups = Arrays.stream(strArr)
                .collect(Collectors.groupingBy(s -> s));

        for (Map.Entry<String, List<String>> entry : nameGroups.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
