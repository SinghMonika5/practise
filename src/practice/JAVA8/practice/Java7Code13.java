package practice.JAVA8.practice;

import java.util.ArrayList;
import java.util.List;

public class Java7Code13 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        int product = findProduct(numbers);
        System.out.println("Product of elements: " + product);
    }

    public static int findProduct(List<Integer> numbers) {
        int product = 1;

	//JAVA 7 SOLUTION
        for (Integer number : numbers) {
            product *= number;
        }

	//JAVA 8 SOLUTION
	int p =	numbers.stream().mapToInt(n->n*n).sum();
    return product;
    }
}
