package practice.JAVA8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapVsFlatMap {

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1,"Gurpreet",95000,true));
        list.add(new Employee(2,"Ritu",21000,false));
        list.add(new Employee(3,"Monika",42000,false));
        list.add(new Employee(4,"Karan",25000,false));
        list.add(new Employee(5,"Sujit",35000,false));


        List<List<Employee>> list2 = new ArrayList<>();

        list2.add(list);


        List<String> names = list.stream().map(Employee::getName).collect(Collectors.toList());
        names.forEach(System.out::println);

        //MERGE ALL LIST INTO ONCE LIST and extract there ids
        List<Integer> emps = list2.stream().flatMap(l->l.stream()).collect(Collectors.toList()).stream().map(Employee::getId).collect(Collectors.toList());
        emps.forEach(System.out::println);

    }
}
