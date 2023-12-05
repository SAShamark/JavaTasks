package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LibraryItem {
    private String title;
    private String author;
    private String isbn;
    private int year;

    public LibraryItem(String title, String author, String isbn, int year) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
    }
}

class Book extends LibraryItem {
    public Book(String title, String author, String isbn, int year) {
        super(title, author, isbn, year);
    }
}

class DVD extends LibraryItem {
    public DVD(String title, String author, String isbn, int year) {
        super(title, author, isbn, year);
    }
}

class Reader {
    private String name;

    public Reader(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Library {
    private List<LibraryItem> availableItems;
    private Map<LibraryItem, Reader> checkedOutItems;
    private List<Reader> readers;

    public Library() {
        this.availableItems = new ArrayList<>();
        this.checkedOutItems = new HashMap<>();
        this.readers = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        availableItems.add(item);
    }
    public List<LibraryItem> getAvailableItems() {
        return availableItems;
    }
    public Map<LibraryItem, Reader> getCheckedOutItems() {
        return checkedOutItems;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void removeItem(LibraryItem item) {
        availableItems.remove(item);
        checkedOutItems.remove(item);
    }

    public void registerReader(Reader reader) {
        readers.add(reader);
    }

    public void checkOutItem(LibraryItem item, Reader reader) {
        if (availableItems.contains(item)) {
            availableItems.remove(item);
            checkedOutItems.put(item, reader);
            System.out.println("Item checked out to " + reader.getName() + ": " + item);
        } else {
            System.out.println("Item not available: " + item);
        }
    }

    public void returnItem(LibraryItem item) {
        if (checkedOutItems.containsKey(item)) {
            availableItems.add(item);
            checkedOutItems.remove(item);
            System.out.println("Item returned: " + item);
        } else {
            System.out.println("Item not checked out: " + item);
        }
    }

    public void displayAvailableItems() {
        System.out.println("Available Items:");
        for (LibraryItem item : availableItems) {
            System.out.println(item);
        }
    }

    public void displayCheckedOutItems() {
        System.out.println("Checked Out Items:");
        for (Map.Entry<LibraryItem, Reader> entry : checkedOutItems.entrySet()) {
            System.out.println("Item: " + entry.getKey() + ", Checked Out to: " + entry.getValue().getName());
        }
    }
}

public class App {
    public static void main(String[] args) {
        Library library = new Library();

        library.addItem(new Book("Java: The Complete Reference", "Herbert Schildt", "978-0071808552", 2014));
        library.addItem(new DVD("Introduction to Java Programming", "John Doe", "978-1234567890", 2020));

        library.displayAvailableItems();

        Reader reader = new Reader("Alice");
        library.registerReader(reader);

        library.checkOutItem(new Book("Java: The Complete Reference", "Herbert Schildt", "978-0071808552", 2014), reader);

        library.displayCheckedOutItems();
        library.displayAvailableItems();

        library.returnItem(new Book("Java: The Complete Reference", "Herbert Schildt", "978-0071808552", 2014));

        library.displayCheckedOutItems();
        library.displayAvailableItems();
    }
}
