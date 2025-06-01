package practice.JAVA8;

import sun.awt.windows.ThemeReader;

import java.util.*;

class Book{

    int id;
    String name;

    public Book(int id,String name){
        this.id=id;
        this.name=name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class BookDao{
    public List<Book> getBooks(){
        List<Book> list = new ArrayList<>();
        list.add(new Book(1,"HP"));
        list.add(new Book(2,"JAVA"));
        list.add(new Book(3,"PHP"));
        list.add(new Book(4,"PERL"));
        list.add(new Book(5,"ORACLE"));
        list.add(new Book(6,"SQL"));
        list.add(new Book(7,"MYSQL"));
        list.add(new Book(8,"ASTERISK"));
        list.add(new Book(9,"JAVASRIPT"));
        return list;
    }
}

class BookService{
    public List<Book> getBookInSort(){
        List<Book> books = new BookDao().getBooks();
        Collections.sort(books,new MyComparator());
        return books;
    }

    public List<Book> getBookInSort2(){
        List<Book> books = new BookDao().getBooks();
        Collections.sort(books,(o1,o2)->o1.name.compareTo(o2.name));
        return books;
    }
}

class MyComparator implements Comparator<Book>{

    public int compare(Book o1,Book o2){
        return o1.name.compareTo(o2.name);
    }
}
public class BookServiceImpl {

    public static void main(String[] args) {
        BookService bs = new BookService();
        System.out.println(bs.getBookInSort2());

        Thread t1 = new Thread(()->{
            System.out.println("This is a thread");
        });

        t1.start();
    }

}
