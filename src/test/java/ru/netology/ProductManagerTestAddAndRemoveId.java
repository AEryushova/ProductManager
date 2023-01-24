package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTestAddAndRemoveId {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product products1 = new Book(14, "Книга", 498, "Джордж Оруэлл", "Скотный двор");
    Product products2 = new Smartphone(3, "Смартфон", 15999, "Honor", "50 Lite");
    Product products3 = new Product(10, "Шампунь", 1100);
    Product products4 = new Product(25, "Ошейник", 890);

    @BeforeEach
    public void save() {
        repo.save(products1);
        repo.save(products2);
        repo.save(products3);
        ;
    }

    @Test
    public void shouldRemoveProductById() {
        repo.removeById(14);
        Product[] expected = {products2, products3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveNonExistentProductById() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(45);
        });
    }

    @Test
    public void shouldAddNewProductInRepo() {
        manager.add(products4);
        Product[] expected = {products1, products2, products3, products4};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThereIsNoProductWithTheSameId() {
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            manager.add(products3);
        });
    }
}