package ru.netology.repository;

import ru.netology.AlreadyExistsException;
import ru.netology.NotFoundException;
import ru.netology.domain.Product;

public class ProductRepository {
    private Product[] products = new Product[0];

    //конструкторы
    public ProductRepository() {

    }

    public ProductRepository(Product[] products) {
        this.products = products;
    }

    //getter and setter

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    //методы
    //метод добавления Product'ов
    public void add(Product product) {

        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;

    }

    //метод получения всех сохранённых Product'ов
    public Product[] findAll() {
        return getProducts();
    }

    //метод удаления по id
    public void removeId(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        Product[] tmp = new Product[products.length - 1];
        int i = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[i] = product;
                i++;
            }
        }
        products = tmp;
    }

    //метод поиска по id
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
