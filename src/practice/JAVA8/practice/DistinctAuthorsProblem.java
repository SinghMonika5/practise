package practice.JAVA8.practice;


import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Book {
    private String title;
    private List<String> authors;

    public Book(String title, List<String> authors) {
        this.title = title;
        this.authors = authors;
    }

    public List<String> getAuthors() {
        return authors;
    }
}

public class DistinctAuthorsProblem {

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("Book 1", Arrays.asList("Author A", "Author B")),
            new Book("Book 2", Arrays.asList("Author B", "Author C")),
            new Book("Book 3", Arrays.asList("Author A", "Author D"))
        );

        Set<String> authors = books.stream()
                .flatMap(book -> book.getAuthors().stream())
                .collect(Collectors.toSet());

        System.out.println("Distinct Authors:");
        authors.forEach(System.out::println);
    }
}
