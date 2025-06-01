package practice.JAVA8.practice;

import java.util.*;
import java.util.stream.Collectors;

public class Practice{


public static void main(String[] args){

//   Write a Java 8 program to find all even numbers from a list of integers.
List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,8,9);
list1.stream().filter((n)->n%2 ==0).forEach(n->System.out.println(n));

//Given a list of strings, write a Java 8 program to filter out strings with a length greater than a specified value.
List<String> list2 = Arrays.asList("1","22","333","4444","4444","333","22");
list2.stream().filter((s)->s.length()==3).forEach(s->System.out.println(s));


//Write a Java 8 program to calculate the average of a list of integers using streams.
 double avg = list1.stream().mapToDouble(i->i).average().orElse(0.0);
    System.out.println("avg: "+avg);

//Given a list of strings, write a Java 8 program to sort them in ascending order.
    List<String> list3 = Arrays.asList("apple","mango","banana","dog","cat","ethernet","orion");
    list3 = list3.stream().sorted().collect(Collectors.toList());
    System.out.println("list3 : "+list3);

//   Given two lists of integers, write a Java 8 program to find the common elements between them.
   List<Integer> intList1 = new ArrayList<>();
   intList1.add(1);
   intList1.add(2);
   intList1.add(3);
   intList1.add(4);
   List<Integer> intList2 = new ArrayList<>();
   intList2.add(1);
   intList2.add(2);
   intList1.retainAll(intList2);//<---
   System.out.println(intList1);

  //   Write a Java 8 program to count the number of words in a given string.
  String name = "Hello how are you";
  long n =  name.chars().filter(c ->(c==' ')).count()+1;
  System.out.println(n);

  //   Given a list of strings, write a Java 8 program to group the words by their length.

   list2 = Arrays.asList("1","22","333","4444","4444","333","22","1");
   Map map = list2.stream().collect(Collectors.groupingBy(String::length));
   System.out.println(map);

   boolean allPrime =  list1.stream().allMatch(num->isPrime(num));
}

public static boolean isPrime2(int num){

    if(num <= 1) return false;
    for(int i=2;i<=Math.sqrt(num);i++){
        if (num%i == 0) return false;
    }
    return true;
}

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }









}