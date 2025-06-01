package practice.JAVA8.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Java7Code10 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(4);
        numbers.add(5);

        List<Integer> uniqueNumbers = removeDuplicates(numbers);
        System.out.println("Unique numbers: " + uniqueNumbers);
    }

    public static List<Integer> removeDuplicates(List<Integer> numbers) {
        List<Integer> uniqueList = new ArrayList<>();

        //JAVA 7 SOLUTION
        for (Integer number : numbers) {
            if (!uniqueList.contains(number)) {
                uniqueList.add(number);
            }
        }

        //JAVA 8 SOLUTION
        uniqueList = numbers.stream().distinct().collect(Collectors.toList());
        return uniqueList;
    }
}
