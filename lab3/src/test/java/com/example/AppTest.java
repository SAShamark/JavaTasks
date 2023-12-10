package com.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    private Cart cart;
    private Product product1;
    private Product product2;

    @Before
    void setUp() {
        cart = new Cart();
        product1 = new Product(1, "Product 1", 10.0);
        product2 = new Product(2, "Product 2", 20.0);
    }

    @Test
    void testAddProductToCart() {
        cart.addProduct(product1);
        cart.addProduct(product2);

        assertEquals(2, cart.getProducts().size());
        assertTrue(cart.getProducts().contains(product1));
        assertTrue(cart.getProducts().contains(product2));
    }

    @Test
    void testRemoveProductFromCart() {
        cart.addProduct(product1);
        cart.addProduct(product2);

        cart.removeProduct(product1);

        assertEquals(1, cart.getProducts().size());
        assertFalse(cart.getProducts().contains(product1));
        assertTrue(cart.getProducts().contains(product2));
    }

    @Test
    void testPlaceOrder() {
        cart.addProduct(product1);
        cart.addProduct(product2);

        Order order = new Order(1, cart.getProducts(), "Pending");

        assertEquals(2, order.getProducts().size());
        assertTrue(order.getProducts().contains(product1));
        assertTrue(order.getProducts().contains(product2));
        assertEquals("Pending", order.getStatus());
    }
}