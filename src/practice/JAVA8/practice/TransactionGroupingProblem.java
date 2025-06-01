package practice.JAVA8.practice;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Transaction {
    private String type;
    private double amount;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
}

public class TransactionGroupingProblem {

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
            new Transaction("Deposit", 1000.0),
            new Transaction("Withdrawal", 500.0),
            new Transaction("Deposit", 1500.0),
            new Transaction("Withdrawal", 200.0)
        );

        Map<String, Double> result = transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getType,
                        Collectors.summingDouble(Transaction::getAmount)
                ));

        System.out.println("Transaction Summary:");
        result.forEach((type, totalAmount) -> {
            System.out.println("Type: " + type + ", Total Amount: " + totalAmount);
        });
    }
}
