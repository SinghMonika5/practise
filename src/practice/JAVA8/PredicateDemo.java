package practice.JAVA8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Predicate<Integer> p = (t)->t%2==0;
        System.out.println(p.test(10));
//        list.stream().filter(p).forEach(t -> System.out.println(t));
        list.stream().filter((t)->t%2==0).forEach(t -> System.out.println(t));
    }

}
