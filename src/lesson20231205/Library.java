package lesson20231205;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Library {

    public static void main(String[] args) {
        Book book1 = new Book("Harry Potter", 10.0, true);
        Book book2 = new Book("Tom Sawyer", 15.0, true);
        Book book3 = new Book("Tom Sawyer", 25.0, true);
        Book book4 = new Book("Tom Sawyer", 35.0, false);

        Map<Book, Integer> bookCount = new HashMap<>();
        bookCount.put(book1, 5);
        bookCount.put(book2, 2);
        bookCount.put(book3, 1);
        bookCount.put(book4, 1);

        System.out.println(bookCount.get(book1));
        System.out.println(bookCount.get(book2));
        System.out.println("Size = " + bookCount.size());

        Map<Book, Integer> bookCount2 = new TreeMap<>();
        bookCount2.putAll(bookCount);
        System.out.println(bookCount2.get(book1));
        System.out.println(bookCount2.get(book2));
        System.out.println("Size = " + bookCount2.size());

        // equals & hashCode: o1.equals(o2) == true ------> o1.hashCode() == o2.hashCode()
        // equals & compareTo: o1.equals(o2) == true <------> o1.compareTo(o2) == 0
    }


}
