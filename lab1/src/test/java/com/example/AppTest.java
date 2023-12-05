package com.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    private Library library;

    @Before
    public void setUp() {
        library = new Library();
        library.addBook(new Book("Java: The Complete Reference", "Herbert Schildt", "978-0071808552", 2014));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0321356680", 2008));
        library.addBook(new Book("Head First Java", "Kathy Sierra, Bert Bates", "978-0596009205", 2005));
    }

    @Test
    public void testAddBook() {
        int initialSize = library.getBooks().size();
        Book newBook = new Book("New Book", "Author", "123-4567890123", 2022);
        library.addBook(newBook);
        assertEquals(initialSize + 1, library.getBooks().size());
        assertTrue(library.getBooks().contains(newBook));
    }

    @Test
    public void testSearchByTitle() {
        String searchTitle = "Effective Java";
        Book foundBook = library.searchByTitle(searchTitle);
        assertNotNull(foundBook);
        assertEquals(searchTitle, foundBook.getTitle());
    }

    @Test
    public void testRemoveBookByIsbn() {
        String isbnToRemove = "978-0321356680";
        int initialSize = library.getBooks().size();
        library.removeBookByIsbn(isbnToRemove);
        assertEquals(initialSize - 1, library.getBooks().size());
        assertNull(library.searchByTitle("Effective Java"));
    }
}