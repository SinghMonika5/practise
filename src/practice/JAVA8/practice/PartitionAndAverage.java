package practice.JAVA8.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }
}

public class PartitionAndAverage {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 18, 90.0),
                new Student("Bob", 22, 80.0),
                new Student("Charlie", 15, 75.0),
                new Student("David", 12, 88.0)
        );

        int THRESHOLD = 20;

        Map<Boolean,Double> averageGradesByAge
                = students.stream().collect(Collectors.partitioningBy(s->s.getAge() >= THRESHOLD,Collectors.averagingDouble(Student::getAge)));

        System.out.println("Average Grades for Older and Younger Students:");
        System.out.println("Older Students: " + averageGradesByAge.get(true));
        System.out.println("Younger Students: " + averageGradesByAge.get(false));
    }
}
