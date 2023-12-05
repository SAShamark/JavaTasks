package com.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Book {
    private String title;
    private String author;
    private String isbn;
    private int year;

    public Book(String title, String author, String isbn, int year) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Year: " + year;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }
    
    public List<Book> getBooks() {
        return books;
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void removeBookByIsbn(String isbn) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getIsbn().equals(isbn)) {
                iterator.remove();
                System.out.println("Book with ISBN " + isbn + " removed from the library.");
                return;
            }
        }
        System.out.println("Book with ISBN " + isbn + " not found in the library.");
    }
}

public class App {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book("Java: The Complete Reference", "Herbert Schildt", "978-0071808552", 2014));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0321356680", 2008));
        library.addBook(new Book("Head First Java", "Kathy Sierra, Bert Bates", "978-0596009205", 2005));

        System.out.println("All Books in the Library:");
        library.displayBooks();
        System.out.println();

        String searchTitle = "Effective Java";
        System.out.println("Searching for book with title: " + searchTitle);
        Book foundBook = library.searchByTitle(searchTitle);
        if (foundBook != null) {
            System.out.println("Book found: " + foundBook);
        } else {
            System.out.println("Book not found in the library.");
        }
        System.out.println();

        String isbnToRemove = "978-0321356680";
        System.out.println("Removing book with ISBN: " + isbnToRemove);
        library.removeBookByIsbn(isbnToRemove);

        System.out.println("\nAll Books in the Library after removal:");
        library.displayBooks();
    }
}
