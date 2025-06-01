package practice.JAVA8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Employee{
    int id;
    String name;
    int salary;
    boolean taxable;

    public Employee(int id, String name, int salary, boolean taxable) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.taxable = taxable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean isTaxable() {
        return taxable;
    }

    public void setTaxable(boolean taxable) {
        this.taxable = taxable;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", taxable=" + taxable +
                '}';
    }
}

public class SteamDemo {

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();

        list.add(new Employee(1,"Gurpreet",95000,true));
        list.add(new Employee(1,"Ritu",21000,false));
        list.add(new Employee(1,"Monika",42000,false));
        list.add(new Employee(1,"Karan",25000,false));
        list.add(new Employee(1,"Sujit",35000,false));

        list.forEach(employee -> System.out.println(employee.name));
        System.out.println("---------------------");
        list =  list.stream().filter(e-> e.salary>30000).collect(Collectors.toList());
        list.forEach(employee -> System.out.println(employee.name));
    }
}
