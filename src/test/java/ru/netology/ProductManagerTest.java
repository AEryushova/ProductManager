package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product products1 = new Book(14, "Книга", 498, "Джордж Оруэлл", "Скотный двор");
    Product products2 = new Smartphone(3, "Смартфон", 15999, "Honor", "50 Lite");
    Product products3 = new Product(10, "Шампунь", 1100);
    Product products4 = new Book(18, "Книга", 498, "Лев Толстой", "Война и мир");


    @BeforeEach
    public void save() {
        repo.save(products1);
        repo.save(products2);
        repo.save(products3);
        repo.save(products4);

    }


    @Test
    public void shouldProductSearchByTitle() {
        Product[] expected = {products2};
        Product[] actual = (manager.searchBy("Смартфон"));
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAllProductSearchByTitle() {
        Product[] expected = {products1, products4};
        Product[] actual = (manager.searchBy("Книга"));
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMatchingTheProductToTheSearchQuery() {
        boolean expected = true;
        boolean actual = manager.matches(products2, "Смартфон");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void noShouldMatchingTheProductToTheSearchQuery() {
        boolean expected = false;
        boolean actual = manager.matches(products2, "Шампунь");
        Assertions.assertEquals(expected, actual);
    }
}
