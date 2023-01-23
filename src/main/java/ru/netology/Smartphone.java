package ru.netology;

public class Smartphone extends Product {
    private String manufacturer;

    private String name;
    ;

    public Smartphone(int id, String title, int price, String manufacturer,String name) {
        super(id, title, price);
        this.manufacturer = manufacturer;
        this.name=name;
    }


    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
