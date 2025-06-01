package practice.JAVA8.practice;

import java.util.ArrayList;
import java.util.List;

public class Java7CodeSum2 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        int countEvenNumbers = countEvenNumbers(numbers);
        System.out.println("Number of even numbers: " + countEvenNumbers);
    }

    public static int countEvenNumbers(List<Integer> numbers) {

        int count = 0;

        //java 8 solution
        count = numbers.stream().filter(n->n%2==0).mapToInt(p->1).sum();
//        or
        long count2 = numbers.stream().filter(n->n%2==0).count();

        //java 7 solution
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
