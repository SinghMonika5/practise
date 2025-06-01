package practice.JAVA8.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Java7Code5 {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("orange");
        fruits.add("grape");
        fruits.add("kiwi");

        List<String> filteredFruits = filterFruits(fruits, "a");
        System.out.println("Filtered fruits: " + filteredFruits);
    }

    public static List<String> filterFruits(List<String> fruits, String filter) {
        List<String> filteredList = new ArrayList<>();

        //JAVA 8 SOLUTION
        filteredList = fruits.stream().filter(f->f.equals(filter)).collect(Collectors.toList());
//        filteredList = fruits.stream().filter(f->f.contains(filter)).collect(Collectors.toList());

        //JAVA 7 SOLUTION
        for (String fruit : fruits) {
            if (fruit.contains(filter)) {
                filteredList.add(fruit);
            }
        }
        return filteredList;
    }
}
