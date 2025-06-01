package practice.JAVA8.practice;

import java.util.ArrayList;
import java.util.List;

public class Java7Code11 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);

        int sumOfEvens = findSumOfEvens(numbers);
        System.out.println("Sum of even numbers: " + sumOfEvens);
    }

    public static int findSumOfEvens(List<Integer> numbers) {
        int sum = 0;

	// JAVA 7 SOLUTION
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                sum += number;
            }
        }

	// JAVA 8 SOLUTION
    sum = numbers.stream().filter(n->n%2==0).mapToInt(n->n).sum();

    return sum;
    }
}
