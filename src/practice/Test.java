package practice;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

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

public class Test {



    public static void main(String[] args){

        List<Person> persons = Arrays.asList(new Person("Alice", Optional.of(25)),
                new Person("Bob", Optional.empty()),
                new Person("Charlie", Optional.of(30)),
                new Person("David", Optional.empty())
        );

        OptionalDouble optional = persons.stream().filter(p->p.getAge().isPresent()).mapToDouble(p->p.getAge().get()).average();



    }
}
