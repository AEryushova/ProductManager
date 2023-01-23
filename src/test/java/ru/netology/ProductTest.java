package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    Product prod1 = new Product(1,"Шампунь", 470);
    Book prod2 = new Book(36,"Книга", 470, "Джордж Оруэлл", "Скотный двор");
    Smartphone prod3 = new Smartphone(1,"Смартфон", 470, "Honor", "50 Lite");

    @Test
    public void shouldSetIdProduct(){
        prod1.setId(40);
        int expected=40;
        int actual=prod1.getId();
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void shouldSetPriceProduct(){
        prod1.setPrice(630);
        int expected=630;
        int actual=prod1.getPrice();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void shouldSetTitleProduct(){
        prod1.setTitle("Крем");
        String expected="Крем";
        String actual=prod1.getTitle();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void shouldSetProductAuthorBook(){
        prod2.setAuthor("Джордж Оруэлл");
        String expected="Джордж Оруэлл";
        String actual=prod2.getAuthor();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void shouldSetProductNameBook(){
        prod2.setName("Скотный двор");
        String expected="Скотный двор";
        String actual=prod2.getName();
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void shouldSetProductManufacturerSmartphone(){
        prod3.setManufacturer("Samsung");
        String expected="Samsung";
        String actual=prod3.getManufacturer();
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void shouldSetProductNameSmartphone(){
        prod3.setName("Galaxy S21");
        String expected="Galaxy S21";
        String actual=prod3.getName();
        Assertions.assertEquals(expected,actual);
    }
}

