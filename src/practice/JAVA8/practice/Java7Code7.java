package practice.JAVA8.practice;

import java.util.ArrayList;
import java.util.List;

public class Java7Code7 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(12);
        numbers.add(5);
        numbers.add(9);
        numbers.add(20);
        numbers.add(3);

        int targetNumber = 9;
        boolean isPresent = checkNumber(numbers, targetNumber);
        System.out.println("Is " + targetNumber + " present? " + isPresent);
    }

    public static boolean checkNumber(List<Integer> numbers, int targetNumber) {

        boolean matched= false;
        //JAVA 8 SOLUTION
        matched = numbers.stream().filter(n->n==targetNumber).findFirst().isPresent();
        //OR
        matched = numbers.stream().anyMatch(n -> n == targetNumber);

        //JAVA 7 SOLUTION
        for (int number : numbers) {
            if (number == targetNumber) {
                return true;
            }
        }
        return false;
    }
}
