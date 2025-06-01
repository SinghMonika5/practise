package practice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class NonRepeatedElement {
    public static void main(String[] args) {
        String s = "monika singh";
        Character cha[]={'a','t'};
       Character ch[]= s.chars().mapToObj(c->(char) c).toArray(Character[]::new);

       boolean isMatch=Arrays.asList(ch).stream().anyMatch(c->c=='t');
        boolean notMatch=Arrays.asList(ch).stream().noneMatch(c->c=='t');
        boolean allMatch=Arrays.asList(cha).stream().allMatch(c->c=='a');

        System.out.println(isMatch);
        System.out.println(notMatch);
        System.out.println(allMatch);

        Map<Character,Long> map= Arrays.asList(ch).stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
         map.forEach((a,b)->System.out.println(a+":"+b));


        List<Character> non=s.replaceAll(" ","")
                .chars()
                .mapToObj(k->(char) k)
                .filter(c->s.indexOf(c)==s.lastIndexOf(c))
                .collect(Collectors.toList());

        System.out.println(non);


        Integer[] arr={1,2,2,3,5,4};
        List<Integer> list2=Arrays.stream(arr).distinct().collect(Collectors.toList());
        List<List<Integer>> lists=new ArrayList<>();
        lists.add(Arrays.asList(1,3,5));
        lists.add(Arrays.asList(2,4,6));
        List<Integer> list=lists.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(list);
        System.out.println(list2);

        List<Integer> list1= Arrays.asList(arr);
        Set<Integer> set=new HashSet<>(list1);
        List<Integer> duplicateValue=new ArrayList<>();
        HashSet<Integer> hashSet=new HashSet<>();
       for(Integer t:arr){
           if(!hashSet.contains(t)){
               hashSet.add(t);
           }
           else{
               duplicateValue.add(t);
           }
       }
       System.out.println("duplicate value"+duplicateValue);


        double d=Arrays.stream(arr).mapToInt(a->a).average().orElse(0.0);
        System.out.println(d);
        int sum=Arrays.stream(arr).reduce(0,(a,b)->a+b);
        Optional<Integer> test=Arrays.stream(arr).reduce((a,b)->a<b?a:b);
if(test.isPresent()){
    test.get();
}
      int max=  Arrays.asList(arr).stream().max((a,b)->a.compareTo(b)).get();
        System.out.println(max);

        System.out.println(sum);





    }
}
