package practice.JAVA8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortListDemo {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        list.add("Six");
        list.stream().sorted().forEach(System.out::println);
        list.stream().sorted((s1,s2)->s2.compareTo(s1)).forEach(s-> System.out.println(s));
        list.stream().sorted(Comparator.reverseOrder()).forEach(s-> System.out.println(s));
        //FUNCTION REFERENCE
        //without function reference
        list.stream().sorted(Comparator.comparing(s->s.hashCode())).forEach(s-> System.out.println(s));
        //with functional reference passing reference of getName function of Employee class
        //list.stream().sorted(Comparator.comparing(Employee::getName)).forEach(s-> System.out.println(s));

    }
}
