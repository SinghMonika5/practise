package practice.JAVA8.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Java7Code6 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(12);
        numbers.add(5);
        numbers.add(9);
        numbers.add(20);
        numbers.add(3);

        int max = findMax(numbers);
        System.out.println("Maximum value: " + max);
    }

    public static int findMax(List<Integer> numbers) {

        int max = Integer.MIN_VALUE;
        //java 8 solution
        max = numbers.stream().max(Comparator.naturalOrder()).get();

        //java 7 solution
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }
}
