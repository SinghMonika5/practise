package practice.DSA;

import java.security.InvalidKeyException;
import java.util.Arrays;



class MyLinkedList<T>{
    private Node<T> root;
    private int size;

    public MyLinkedList(){
        root=null;
        size=0;
    }

    public int size(){return size;}

    public boolean isEmpty(){return size==0;}

    public void add(T element){
        Node<T> newNode= new Node<>(element);
        if(root == null){
            //root node
            root = new Node<>(element);
        }else{
            Node<T> current = root;
            while (current.next != null){
               current = current.next;

            }
            current.next=newNode;
        }
        size++;
    }

    public T get(int index) throws InvalidKeyException {
        Node<T> current = root;

        if(index < 0 || index >= size) throw new InvalidKeyException("Index not found");
        for (int i=0;i<index;i++){
            System.out.println(i);
            current = current.next;
        }
        return current.data;
    }

    public void remove(int index) throws InvalidKeyException {
         if(index < 0 || index >= size) throw new InvalidKeyException("Index not found");
        if (index == 0){
            root=root.next;
        }else{
         Node<T> current = root;
         for (int i=0;i<index-1;i++){
             current= current.next;
        }
        current.next = current.next.next;
        }
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = root;
        while (current != null){
            sb.append(current.data);
            if (current.next != null)sb.append(",");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public void reverse(){

        if (root == null || root.next == null){
            return;
        }
        Node<T> prev = null;
        Node<T> current = root;
        Node<T> next = null;

        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        root=prev;
    }
    private static class Node<T>{
        T data;
        Node<T> prev;
        Node<T> next;

        public Node(T data){
            this.data=data;
            this.prev=null;
            this.next=null;
        }
    }

}
public class LinkedListImpl {

    public static void main(String[] args) throws InvalidKeyException {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        System.out.println(list);
//        System.out.println(list.get(5));
//      list.remove(1);
        list.reverse();
        System.out.println(list);
    }




}
