package practice.DSA;

import sun.rmi.transport.ObjectTable;

import java.util.Arrays;

class MyArrayList<T>{

    private final int INITIAL_SIZE=10;
    private Object[] list;
    private int size;

    public MyArrayList(){
        this.list = new Object[INITIAL_SIZE];
        this.size = 0;
    }

    public void add(T element){
        verifySize();
        list[size] = element;
        size++;

    }

    public T get(int index){
        if (index < 0 || index >= size){
            throw new NullPointerException();
        }
        return (T) list[index];
    }

    public boolean remove(int index){
        if (index < 0 || index >= size){
            return false;
        }

        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }
        list[size - 1] = null;
        size--;
        return true;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void verifySize(){
        if (this.list.length == size){
            list = Arrays.copyOf(list,list.length*2);
        }
    }


}



public class ArrayListImple {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();

        System.out.println(list.isEmpty());
        list.add("One");
        list.add("Two");
        System.out.println(list.isEmpty());
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println("---removing---");
        list.remove(0);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
    }
}
