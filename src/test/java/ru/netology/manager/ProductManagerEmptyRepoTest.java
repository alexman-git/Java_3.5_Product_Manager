package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerEmptyRepoTest {
    ProductManager manager = new ProductManager();

    @Test
    void shouldNotFindItemsWhenRepoIsEmpty() {
        Product[] actual = manager.searchBy("book");
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }
}
