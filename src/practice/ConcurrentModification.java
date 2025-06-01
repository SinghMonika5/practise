package practice;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ConcurrentModification {

    public static void main(String[] args) {



        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        for (int i=0;i<list.size();i++){
            list.remove(0);
        }

        Iterator<Integer> iterator = list.iterator();

        int i = 0;

        while (iterator.hasNext()){
            int j = iterator.next();
            System.out.println(j);
            if (i == 2){
                iterator.remove();
            }
                i++;
        }

        iterator = list.iterator();
        while (iterator.hasNext()){
            int j = iterator.next();
            System.out.println(j);

        }


    }
}
