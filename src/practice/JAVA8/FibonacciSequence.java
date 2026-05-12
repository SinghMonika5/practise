package practice.JAVA8;

import java.util.function.UnaryOperator;
import java.util.stream.Stream;
import java.util.List;
import java.util.stream.Collectors;

public class FibonacciSequence {

    public static List<Integer> generateFibonacci(int n) {



        return Stream.iterate(new int[]{0, 1}, fib -> new int[]{fib[1], fib[0] + fib[1]})
            .limit(n)
            .map(fib -> fib[0])
            .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        Stream.iterate(new int[]{0,1},fib->new int[]{fib[1],fib[0]+fib[1]})
                .limit(10)
                .map(fib->fib[0])
                .collect(Collectors.toList());

        int n = 10; // Generate first 10 Fibonacci numbers

        List<Integer> fibonacciSequence = generateFibonacci(n);

        System.out.println(fibonacciSequence); // Output: [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
    }
}
