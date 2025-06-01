package practice.JAVA8.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class Order {
    private int orderNumber;
    private double totalAmount;

    public Order(int orderNumber, double totalAmount) {
        this.orderNumber = orderNumber;
        this.totalAmount = totalAmount;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}

public class HighestTotalAmountOrder {

    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order(1, 150.0),
                new Order(2, 80.0),
                new Order(3, 200.0),
                new Order(4, 50.0)
        );

        Optional<Order> highestAmountOrder = orders.stream()
                .reduce((order1, order2) -> order1.getTotalAmount() > order2.getTotalAmount() ? order1 : order2);

        highestAmountOrder.ifPresent(order -> {
            System.out.println("Order with Highest Total Amount:");
            System.out.println("Order Number: " + order.getOrderNumber());
            System.out.println("Total Amount: " + order.getTotalAmount());
        });
    }
}
