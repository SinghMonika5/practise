package practice.JAVA8.practice;

import java.util.Arrays;
import java.util.Comparator;

public class IntArrayReverse {


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        arr = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).mapToInt(n->n).toArray();
        Arrays.stream(arr).forEach(System.out::println);
    }
}
