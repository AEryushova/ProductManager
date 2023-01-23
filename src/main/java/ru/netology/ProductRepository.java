package ru.netology;

public class ProductRepository {

    private Product[] products = new Product[0];


    public Product[] findAll() {
        return products;
    }


    public void removeById(int id) {
        Product[] tmp = new Product[products.length - 1];
        int copyIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyIndex] = product;
                copyIndex++;
            }
        }
        products = tmp;
    }

    public void save(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }
}

