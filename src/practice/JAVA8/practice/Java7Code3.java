package practice.JAVA8.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Java7Code3 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Alice");
        names.add("Bob");
        names.add("Eve");

        String concatenatedNames = concatenateNames(names);
        System.out.println("Concatenated names: " + concatenatedNames);
    }

    public static String concatenateNames(List<String> names) {

        String s;
        //java 8 solution
        s = names.stream().collect(Collectors.joining(", "));



        //java 7 solution
        StringBuilder stringBuilder = new StringBuilder();
        for (String name : names) {
            stringBuilder.append(name).append(", ");
        }
        s=stringBuilder.toString();
        return s;
    }
}
