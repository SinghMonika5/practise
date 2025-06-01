package practice.JAVA8.practice;


import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private List<String> projects;

    public Employee(String name, List<String> projects) {
        this.name = name;
        this.projects = projects;
    }

    public List<String> getProjects() {
        return projects;
    }
}

public class DistinctProjectNames {

    public static void main(String[] args) {
        Employee[] employees = {
            new Employee("Alice", Arrays.asList("Project A", "Project B")),
            new Employee("Bob", Arrays.asList("Project B", "Project C")),
            new Employee("Charlie", Arrays.asList("Project A", "Project D"))
        };

        List<Employee> empList = Arrays.asList(
                new Employee("Alice", Arrays.asList("Project A", "Project B")),
                new Employee("Bob", Arrays.asList("Project B", "Project C")),
                new Employee("Charlie", Arrays.asList("Project A", "Project D"))
        );


        List<String> distinctProjects = Arrays.stream(employees)
                .flatMap(employee -> employee.getProjects().stream())
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Distinct Project Names:");
        distinctProjects.forEach(System.out::println);
    }
}
