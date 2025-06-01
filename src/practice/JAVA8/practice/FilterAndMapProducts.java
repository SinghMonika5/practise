package practice.JAVA8.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

public class FilterAndMapProducts {

    public static void main(String[] args) {

        //find product costlier than priceThreshold;

        List<Product> products = Arrays.asList(
                new Product("Product A", 150.0),
                new Product("Product B", 80.0),
                new Product("Product C", 200.0),
                new Product("Product D", 50.0)
        );

        double priceThreshold = 100.0;

        List<String> expensiveProductNames = products.stream()
                .filter(product -> product.getPrice() > priceThreshold)
                .map(Product::getName)
                .collect(Collectors.toList());

        System.out.println("Expensive Product Names:");
        expensiveProductNames.forEach(System.out::println);
    }
}
