package practice.JAVA8.practice;

import java.util.ArrayList;
import java.util.List;

public class Java7Code9 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("john");
        names.add("alice");
        names.add("bob");
        names.add("eve");

        int maxLength = findMaxLength(names);
        System.out.println("Length of the longest string: " + maxLength);
    }

    public static int findMaxLength(List<String> names) {
        int maxLength = 0;

        //java 8 solution
        maxLength = names.stream().mapToInt(String::length).max().getAsInt();

        //java 7 solution
        for (String name : names) {
            if (name.length() > maxLength) {
                maxLength = name.length();
            }
        }
        return maxLength;
    }
}
