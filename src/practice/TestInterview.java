package practice;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestInterview {
    public static void main(String[] args) throws FileNotFoundException {
        File file=new File("/home/monika/Downloads/");
        FileInputStream fileInputStream=new FileInputStream(file);

        HashMap<String,String> hashMap=new HashMap<>();
//        hashMap.put("name","monika");
//        hashMap.put("address","delhi");
//
//        for(Map.Entry<String,String> map:hashMap.entrySet()){
//            System.out.println("key:"+map.getKey());
//            System.out.println("value:"+map.getValue());
//        }
        String s="wrapper";
        String s1="a b c";
        s1=s1.replaceAll(" ","");
        System.out.println("s1 after removing spaces "+s1);
//       List<Character> nonRepeatedChar= s.chars().mapToObj(c->(char) c)
//                .filter(c->s.indexOf(c)==s.lastIndexOf(c))
//                .collect(Collectors.toList());
//
//       System.out.println("Non Repeated Characte:"+nonRepeatedChar);

             List<Character> repeatedChar= s.chars().mapToObj(c->(char) c)
                .filter(c->s.indexOf(c)!=s.lastIndexOf(c))
                .collect(Collectors.toList());
        repeatedChar=repeatedChar.stream().distinct().collect(Collectors.toList());
       System.out.println(" Repeated Characte:"+repeatedChar);

       String s3="helloworld";
       s3= s3.substring(0,5)+ " "+s3.substring(5,10);
       System.out.println("==="+s3);

       System.out.println(s3);


    }
}
