package ru.netology.manager;

import lombok.Data;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

@Data

public class ProductManager {
    private ProductRepository repository = new ProductRepository();

    public ProductManager() {
    }

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getAuthor().toLowerCase().contains(search.toLowerCase())) {
                return true;
            }
            if (book.getName().toLowerCase().contains(search.toLowerCase())) {
                return true;
            }
            return false;
        }
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getTrademark().toLowerCase().contains(search.toLowerCase())) {
                return true;
            }
            if (smartphone.getName().toLowerCase().contains(search.toLowerCase())) {
                return true;
            }
            return false;
        }
        if (product.getName().toLowerCase().contains(search.toLowerCase())) {
            return true;
        } else {
            return false;
        }
    }
}
