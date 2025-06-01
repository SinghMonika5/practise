package practice.JAVA8.practice;

import java.util.ArrayList;
import java.util.List;

public class Java7Code12 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Alice");
        names.add("Bob");
        names.add("Eve");

        String targetName = "Bob";
        boolean isPresent = checkName(names, targetName);
        System.out.println("Is " + targetName + " present? " + isPresent);
    }

    public static boolean checkName(List<String> names, String targetName) {


    //JAVA 8 SOLUTION
    boolean b = names.stream().anyMatch(n->n.equals(targetName));


	//JAVA 7 SOLUTION
        for (String name : names) {
            if (name.equals(targetName)) {
                return true;
            }
        }
        return false;
    }
}
