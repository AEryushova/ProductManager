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
    Product products4 = new Product(25, "Ошейник", 890);
    Product products5 = new Book(18, "Книга", 498, "Лев Толстой", "Война и мир");



    @BeforeEach
    public void save() {
        repo.save(products2);
        repo.save(products3);
        repo.save(products4);
    }

    @Test
    public void shouldAddNewProductInRepo() {
        manager.add(products1);
        Product[] expected = {products2, products3, products4, products1};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldProductSearchByTitle(){
        manager.searchBy("Смартфон");
        Product[]expected={products2};
        Product[] actual ={products2};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAllProductSearchByTitle(){
        manager.add(products1);
        manager.add(products5);
        manager.searchBy("Книга");
        Product[]expected={products1,products5};
        Product[] actual = {products1,products5};
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldMatchingTheProductToTheSearchQuery(){
        manager.matches(products2,"Смартфон");
        boolean expected = true;
        boolean actual = true;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void notMatchingTheProductToTheSearchQuery(){
        manager.matches(products2,"Книга");
        boolean expected = false;
        boolean actual = false;
        Assertions.assertEquals(expected, actual);
    }


}

