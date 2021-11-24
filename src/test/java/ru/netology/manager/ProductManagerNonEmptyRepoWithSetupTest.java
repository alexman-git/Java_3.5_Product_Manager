package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerNonEmptyRepoWithSetupTest {

    private Product printer = new Product(0, "firstPrinter", 2000);
    private Product firstBook = new Book(1, "firstBook", 100, "firstAuthor");
    private Product secondBook = new Book(2, "secondBook", 200, "secondAuthor");
    private Product firstSmart = new Smartphone(3, "firstSmart", 100, "Samsung");
    private Product secondSmart = new Smartphone(4, "secondSmart", 400, "Author");
    private Product scanner = new Product(5, "firstScanner", 1000);
    private Product thirdSmart = new Smartphone(6, "thirdSmart", 1000, "First");
    private Product thirdBook = new Book(7, "thirdBook", 300, "thirdAuthor");
    private Product notebook = new Product(8, "notebook", 10000);

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    @BeforeEach
    public void setUp() {
        manager.add(printer);
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(firstSmart);
        manager.add(secondSmart);
        manager.add(scanner);
        manager.add(thirdBook);
        manager.add(thirdSmart);
        manager.add(notebook);
    }

    @Test
    void shouldFindAllItemsContainingBook() {
        Product[] actual = manager.searchBy("book");
        Product[] expected = new Product[]{firstBook, secondBook, thirdBook, notebook};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllItemsContainingFirst() {
        Product[] actual = manager.searchBy("First");
        Product[] expected = new Product[]{printer, firstBook, firstSmart, scanner, thirdSmart};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllItemsContainingAuthor() {
        Product[] actual = manager.searchBy("author");
        Product[] expected = new Product[]{firstBook, secondBook, secondSmart, thirdBook};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindItems() {
        Product[] actual = manager.searchBy("auto");
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllItemsContainingEr() {
        Product[] actual = manager.searchBy("er");
        Product[] expected = new Product[]{printer, scanner};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllItemsContainingSamsung() {
        Product[] actual = manager.searchBy("samsung");
        Product[] expected = new Product[]{firstSmart};
        assertArrayEquals(expected, actual);
    }
}
