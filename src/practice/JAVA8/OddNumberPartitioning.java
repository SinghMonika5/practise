package practice.JAVA8;

import java.util.*;
import java.util.stream.Collectors;

public class OddNumberPartitioning {
    public static void main(String[] args) {
        int[] arr = {5, 12, 8, 3, 17, 9, 6, 15};

        Map<Boolean, List<Integer>> partitionedMap = Arrays.stream(arr)
                .filter(n -> n % 2 != 0)
                .boxed() // Convert to Integer
                .collect(Collectors.partitioningBy(n -> n > 10));

        List<Integer> greaterThan10 = partitionedMap.get(true);
        List<Integer> lessThanOrEqual10 = partitionedMap.get(false);

        System.out.println("Odd numbers greater than 10: " + greaterThan10);
        System.out.println("Odd numbers less than or equal to 10: " + lessThanOrEqual10);
    }
}
