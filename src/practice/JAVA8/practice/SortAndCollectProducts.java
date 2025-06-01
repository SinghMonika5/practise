package practice.JAVA8.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortAndCollectProducts {

    public static void main(String[] args) {
        Product[] products = {
            new Product("Product A", 150.0),
            new Product("Product B", 80.0),
            new Product("Product C", 200.0),
            new Product("Product D", 50.0)
        };

        List<String> sortedProductNames = Arrays.stream(products)
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .map(Product::getName)
                .collect(Collectors.toList());

        System.out.println("Sorted Product Names by Price (Descending):");
        sortedProductNames.forEach(System.out::println);
    }
}


