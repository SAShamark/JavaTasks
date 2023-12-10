package com.example;

import org.junit.Before;
import org.junit.Test;

import scala.collection.immutable.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ECommerceSystemTest {

    private Product product1;
    private Product product2;
    private Cart cart;
    private Order order;

    @Before
    public void setUp() {
        product1 = new Product(1, "Laptop", 1200.0);
        product2 = new Product(2, "Smartphone", 800.0);
        cart = new Cart();
        order = new Order(new ArrayList<>());
    }

    @Test
    public void testAddProductToCart() {
        cart.addProduct(product1);
        assertEquals(1, cart.getProducts().size());
        assertTrue(cart.getProducts().contains(product1));
    }

    @Test
    public void testRemoveProductFromCart() {
        cart.addProduct(product1);
        cart.removeProduct(product1);
        assertEquals(0, cart.getProducts().size());
        assertFalse(cart.getProducts().contains(product1));
    }

    @Test
    public void testPlaceOrder() {
        List<Product> productsInCart = new ArrayList<>();
        productsInCart.add(product1);
        productsInCart.add(product2);

        cart.addProduct(product1);
        cart.addProduct(product2);

        // Mocking order placement
        Order mockedOrder = mock(Order.class);
        when(mockedOrder.getOrderId()).thenReturn(1);
        when(mockedOrder.getProducts()).thenReturn(productsInCart);

        assertEquals("Pending", mockedOrder.getStatus());

        // Simulate placing the order
        order = mockedOrder;
        order.setStatus("Processing");

        assertEquals("Processing", order.getStatus());
        assertEquals(2, order.getProducts().size());
        assertTrue(order.getProducts().contains(product1));
        assertTrue(order.getProducts().contains(product2));
    }

    @Test
    public void testGetOrderStatus() {
        order.setStatus("Shipped");
        assertEquals("Shipped", order.getStatus());
    }
}