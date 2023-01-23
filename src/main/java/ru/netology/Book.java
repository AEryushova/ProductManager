package ru.netology;

public class Book extends Product {

    private String author;
    private String name;

    public Book(int id, String title, int price, String author,String name) {
        super(id, title, price);
        this.author = author;
        this.name=name;

    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
