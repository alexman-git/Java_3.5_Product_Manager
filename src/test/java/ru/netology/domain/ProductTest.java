package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Product printer = new Product(0, "firstPrinter", 2000);
    private Product firstBook = new Book(1, "firstBook", 100, "firstAuthor");
    private Product secondBook = new Book(2, "secondBook", 200, "secondAuthor");
    private Product firstSmart = new Smartphone(3, "firstSmart", 100, "Samsung");
    private Product secondSmart = new Smartphone(4, "secondSmart", 400, "Iphone");
    private Product scanner = new Product(5, "firstScanner", 1000);
    private Product thirdSmart = new Smartphone(6, "thirdSmart", 1000, "Lenovo");
    private Product thirdBook = new Book(7, "thirdBook", 300, "thirdAuthor");
    private Product notebook = new Product(8, "notebook", 10000);
    private Product superproduct = new Product();

    @Test
    void shouldNotMatchByName() {
        String search = "scanner";
        assertFalse(printer.matches(search));
    }

    @Test
    void shouldMatchByName() {
        String search = "printer";
        assertTrue(printer.matches(search));
    }
}
