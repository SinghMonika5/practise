package practice;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student>{
     int rollNo;
     String name;
     String dept;

    Student(int rollNo,String name,String dept){
        this.rollNo=rollNo;
        this.name=name;
        this.dept=dept;

    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student student) {
//        return this.rollNo-student.rollNo;
       return this.dept.compareTo(student.dept);
    }
}
class MyComparator implements Comparator<Student>{

    @Override
    public int compare(Student student, Student t1) {
        return student.name.compareTo(t1.name);
    }
}
public class CompatorExample {
    public static void main(String[] args) {
        List<Student> students=new ArrayList<>();
        students.add(new Student(2,"kavi","vb"));
        students.add(new Student(1,"monika","java"));
        students.add(new Student(3,"nanai","dotnet"));
        System.out.println("before sorting"+students);

//        Collections.sort(students);
        Collections.sort(students,new MyComparator());
        System.out.println("after sorting"+students);


    }
}
