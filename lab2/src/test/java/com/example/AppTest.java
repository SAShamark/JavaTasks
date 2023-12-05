package com.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    private Library library;
    private Reader reader;

    @Before
    public void setUp() {
        library = new Library();
        library.addItem(new Book("Java: The Complete Reference", "Herbert Schildt", "978-0071808552", 2014));
        library.addItem(new DVD("Introduction to Java Programming", "John Doe", "978-1234567890", 2020));
        reader = new Reader("Alice");
    }

    @Test
    public void testAddItem() {
        int initialSize = library.getAvailableItems().size();
        LibraryItem newItem = new Book("New Book", "Author", "123-4567890123", 2022);
        library.addItem(newItem);
        assertEquals(initialSize + 1, library.getAvailableItems().size());
        assertTrue(library.getAvailableItems().contains(newItem));
    }

    @Test
    public void testRemoveItem() {
        int initialSize = library.getAvailableItems().size();
        LibraryItem itemToRemove = new Book("Java: The Complete Reference", "Herbert Schildt", "978-0071808552", 2014);
        library.removeItem(itemToRemove);
        assertEquals(initialSize - 1, library.getAvailableItems().size());
        assertFalse(library.getAvailableItems().contains(itemToRemove));
    }

    @Test
    public void testRegisterReader() {
        int initialSize = library.getReaders().size();
        Reader newReader = new Reader("Bob");
        library.registerReader(newReader);
        assertEquals(initialSize + 1, library.getReaders().size());
        assertTrue(library.getReaders().contains(newReader));
    }

    @Test
    public void testCheckOutItem() {
        LibraryItem itemToCheckOut = new Book("Java: The Complete Reference", "Herbert Schildt", "978-0071808552", 2014);
        library.checkOutItem(itemToCheckOut, reader);
        assertTrue(library.getCheckedOutItems().containsKey(itemToCheckOut));
        assertEquals(reader, library.getCheckedOutItems().get(itemToCheckOut));
        assertFalse(library.getAvailableItems().contains(itemToCheckOut));
    }

    @Test
    public void testReturnItem() {
        LibraryItem itemToReturn = new Book("Java: The Complete Reference", "Herbert Schildt", "978-0071808552", 2014);
        library.checkOutItem(itemToReturn, reader);
        library.returnItem(itemToReturn);
        assertFalse(library.getCheckedOutItems().containsKey(itemToReturn));
        assertTrue(library.getAvailableItems().contains(itemToReturn));
    }

    @Test
    public void testDisplayAvailableItems() {
        // Тест виводу доступних предметів в консоль
        library.displayAvailableItems();
    }

    @Test
    public void testDisplayCheckedOutItems() {
        // Тест виводу взятих предметів та їхніх читачів в консоль
        library.displayCheckedOutItems();
    }
}
