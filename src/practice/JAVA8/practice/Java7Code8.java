package practice.JAVA8.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Java7Code8 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("john");
        names.add("alice");
        names.add("bob");
        names.add("eve");

        List<String> uppercaseNames = convertToUppercase(names);
        System.out.println("Uppercase names: " + uppercaseNames);
    }

    public static List<String> convertToUppercase(List<String> names) {
        List<String> uppercaseList = new ArrayList<>();

        uppercaseList = names.stream().map(String::toUpperCase).collect(Collectors.toList());

        for (String name : names) {
            uppercaseList.add(name.toUpperCase());
        }
        return uppercaseList;
    }
}
