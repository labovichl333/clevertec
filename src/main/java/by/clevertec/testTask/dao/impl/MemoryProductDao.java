package by.clevertec.testTask.dao.impl;

import by.clevertec.testTask.dao.ProductDao;
import by.clevertec.testTask.exeption.ProductNotFoundExeption;
import by.clevertec.testTask.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MemoryProductDao implements ProductDao {
    private List<Product> products;

    public MemoryProductDao() {
        this.products = new ArrayList<>(Arrays.asList(
                new Product(1, "Milk", 170, true),
                new Product(2, "Beer", 210, false),
                new Product(3, "Sausage", 560, false),
                new Product(4, "Fish", 1099, true)));
    }

    @Override
    public List<Product> getProducts(List<Integer> ids) {
        return ids.stream()
                .map(id -> products.stream()
                        .filter(product -> id.equals(product.getId()))
                        .findAny()
                        .orElseThrow(() -> new ProductNotFoundExeption("Product with id: " + id + " not found")))
                .collect(Collectors.toList());
    }
}
