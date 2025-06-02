import java.util.ArrayList;

// Book class
class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean available;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void borrow() {
        if (available) {
            available = false;
            System.out.println("Book \"" + title + "\" has been borrowed.");
        } else {
            System.out.println("Book \"" + title + "\" is not available.");
        }
    }

    public void returnBook() {
        available = true;
        System.out.println("Book \"" + title + "\" has been returned.");
    }
}

// User class
class User {
    protected String name;
    protected String userId;

    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
    }

    public void viewBooks(ArrayList<Book> books) {
        System.out.println(name + " is viewing the books:");
        for (Book b : books) {
            System.out.println("- " + b.getTitle() + (b.isAvailable() ? " (Available)" : " (Not Available)"));
        }
    }
}

// Librarian class
class Librarian extends User {
    public Librarian(String name, String userId) {
        super(name, userId);
    }

    public void addBook(Book book, ArrayList<Book> library) {
        library.add(book);
        System.out.println("Book \"" + book.getTitle() + "\" added by librarian.");
    }

    public void removeBook(Book book, ArrayList<Book> library) {
        library.remove(book);
        System.out.println("Book \"" + book.getTitle() + "\" removed by librarian.");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        ArrayList<Book> library = new ArrayList<>();

        // Create librarian and user
        Librarian librarian = new Librarian("Mr. Amin", "L001");
        User student = new User("Sima", "U100");

        // Create books
        Book book1 = new Book("Java Programming", "James Gosling", "ISBN001");
        Book book2 = new Book("Data Structures", "Seymour Lipschutz", "ISBN002");

        // Librarian adds books
        librarian.addBook(book1, library);
        librarian.addBook(book2, library);

        // User views books
        student.viewBooks(library);

        // User borrows a book
        book1.borrow();

        // User returns the book
        book1.returnBook();

        // Librarian removes a book
        librarian.removeBook(book2, library);

        // Final book list
        student.viewBooks(library);
    }
}