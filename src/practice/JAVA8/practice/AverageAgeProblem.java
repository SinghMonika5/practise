package practice.JAVA8.practice;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Optional;
import java.util.stream.Collectors;

class Person{
    private String name;
    private Optional<Integer> age;

    public Person(String name, Optional<Integer> age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Optional<Integer> getAge() {
        return age;
    }
}

public class AverageAgeProblem {

    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(new Person("Alice", Optional.of(25)),
            new Person("Bob", Optional.empty()),
            new Person("Charlie", Optional.of(30)),
            new Person("David", Optional.empty())
        );

        OptionalDouble averageAge = persons.stream()
                .filter(person -> person.getAge().isPresent())
                .mapToDouble(person -> person.getAge().get())
                .average();

        if (averageAge.isPresent()) {
            System.out.println("Average Age: " + averageAge.getAsDouble());
        } else {
            System.out.println("No ages present to calculate the average.");
        }
    }
}
