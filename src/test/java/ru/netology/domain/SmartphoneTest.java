package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    private Product printer = new Product(0, "firstPrinter", 2000);
    private Product firstBook = new Book(1, "firstBook", 100, "firstAuthor");
    private Product secondBook = new Book(2, "secondBook", 200, "secondAuthor");
    private Product firstSmart = new Smartphone(3, "firstSmart", 100, "Samsung");
    private Product secondSmart = new Smartphone(4, "secondSmart", 400, "Iphone");
    private Product scanner = new Product(5, "firstScanner", 1000);
    private Product thirdSmart = new Smartphone(6, "thirdSmart", 1000, "Lenovo");
    private Product thirdBook = new Book(7, "thirdBook", 300, "thirdAuthor");
    private Product notebook = new Product(8, "notebook", 10000);
    private Product supersmart = new Smartphone();

    @Test
    void shouldNotMatchByName() {
        String search = "bat";
        assertFalse(secondSmart.matches(search));
    }

    @Test
    void shouldMatchByName() {
        String search = "smart";
        assertTrue(secondSmart.matches(search));
    }

    @Test
    void shouldMatchByTrademark() {
        String search = "Lenovo";
        assertTrue(thirdSmart.matches(search));
    }

    @Test
    void shouldNotMatchByTrademark() {
        String search = "Pushkin";
        assertFalse(firstSmart.matches(search));
    }

    @Test
    void shouldMatchByNameWithNameSetup() {
        String search = "space";
        supersmart.setName("Great Space");
        assertTrue(supersmart.matches(search));
    }
}
