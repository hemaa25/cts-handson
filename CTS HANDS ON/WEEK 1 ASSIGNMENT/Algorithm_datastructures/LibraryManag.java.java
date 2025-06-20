import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return bookId + " - " + title + " by " + author;
    }
}

public class LibraryManag{

    public static Book linearSearch(Book[] books, String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String title) {
        int left = 0, right = books.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);
            if (cmp == 0) return books[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void printAllBooks(Book[] books) {
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "Java Programming", "James Gosling"),
            new Book(2, "Python Basics", "Guido van Rossum"),
            new Book(3, "C Programming", "Dennis Ritchie"),
            new Book(4, "Effective Java", "Joshua Bloch"),
            new Book(5, "Data Structures", "Robert Lafore")
        };

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter title to search (Linear Search): ");
        String title1 = sc.nextLine();
        Book result1 = linearSearch(books, title1);
        System.out.println(result1 != null ? "Found: " + result1 : "Book not found.");

        Arrays.sort(books, Comparator.comparing(b -> b.title.toLowerCase()));

        System.out.print("Enter title to search (Binary Search): ");
        String title2 = sc.nextLine();
        Book result2 = binarySearch(books, title2);
        System.out.println(result2 != null ? "Found: " + result2 : "Book not found.");
    }
}
