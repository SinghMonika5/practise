package practice.JAVA8;

import java.util.Arrays;
import java.util.List;

public class MaxMinFinder {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 7);

        int max = numbers.stream().reduce(Integer.MIN_VALUE, Integer::max);
        int min = numbers.stream().reduce(Integer.MAX_VALUE, Integer::min);


        System.out.println("Maximum value: " + max);
        System.out.println("Minimum value: " + min);
    }
}
