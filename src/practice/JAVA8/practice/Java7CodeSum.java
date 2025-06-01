package practice.JAVA8.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Java7CodeSum {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        int sumOfSquares = calculateSumOfSquares(numbers);
        System.out.println("Sum of squares: " + sumOfSquares);
    }

    public static int calculateSumOfSquares(List<Integer> numbers) {

        int sum = 0;
        //JAVA 8 SOLUTION
        sum =  numbers.stream().mapToInt(n->n*n).sum();

        //JAVA 7 SOLUTION
        for (Integer number : numbers) {
            sum += number * number;
        }
        return sum;
    }
}
