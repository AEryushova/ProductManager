package ru.netology;

public class ProductRepository {

    private Product[] products = new Product[0];


    public Product[] findAll() {
        return products;
    }


    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        } else {
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
    }

    public Product[] findById(int id) {
        Product[] result = new Product[0];
        for (Product prod : products) {
            if (prod.getId() == id) {
                Product[] searchId = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    searchId[i] = result[i];
                }
                searchId[searchId.length - 1] = prod;
                result = searchId;
                return result;
            }
        }
        return null;
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

