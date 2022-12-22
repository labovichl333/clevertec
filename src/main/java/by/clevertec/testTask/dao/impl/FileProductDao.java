package by.clevertec.testTask.dao.impl;

import by.clevertec.testTask.dao.ProductDao;
import by.clevertec.testTask.exeption.DaoException;
import by.clevertec.testTask.exeption.ProductNotFoundExeption;
import by.clevertec.testTask.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static by.clevertec.testTask.constant.Constants.*;

public class FileProductDao implements ProductDao {
    private String fileName;

    public FileProductDao(String param) {
        fileName = param;
    }

    @Override
    public List<Product> getProducts(List<Integer> ids) throws DaoException {
        List<Product> products = new ArrayList<>();
        try (Scanner sc = new Scanner(this.getClass().getResourceAsStream("/" + fileName))) {
            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(DELIMITER_TXT);
                products.add(new Product(
                        Integer.parseInt(line[IND_PRODUCT_ID]),
                        line[IND_PRODUCT_NAME],
                        Integer.parseInt(line[IND_PRODUCT_PRICE]),
                        Boolean.parseBoolean(line[IND_PRODUCT_IS_DISCOUNT])));
            }
            return ids.stream()
                    .map(id -> products.stream()
                            .filter(product -> id.equals(product.getId()))
                            .findAny()
                            .orElseThrow(() -> new ProductNotFoundExeption("Product with id: " + id + " not found")))
                    .collect(Collectors.toList());
        }
    }
}
