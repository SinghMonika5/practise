package practice.JAVA8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {
        Supplier<String> supplier = ()-> "hello world";
        System.out.println(supplier.get());

        List<String> list = Arrays.asList(args);
        System.out.println(list.stream().findAny().orElseGet(supplier));
        System.out.println(list.stream().findAny().orElseGet(()->"no value found"));
    }
}
