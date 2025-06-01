package practice.JAVA8.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Java7Code4 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        double average = calculateAverage(numbers);
        System.out.println("Average: " + average);
    }

    public static double calculateAverage(List<Integer> numbers) {

        double avg = 0;
        int sum = 0;

        //java 8 solution
        avg = numbers.stream().mapToDouble(n->n).average().orElse(0.0);

        //java 7 solution
        for (Integer number : numbers) {
            sum += number;
        }


        return (double) sum / numbers.size();
    }
}
