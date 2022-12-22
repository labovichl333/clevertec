package by.clevertec.testTask.dao.impl;

import by.clevertec.testTask.exeption.DaoException;
import by.clevertec.testTask.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileProductDaoTest {
    List<Integer> ids;

    @BeforeEach
    void setUp() {
        ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
    }

    @Test
    void getProducts() throws DaoException {
        FileProductDao productDao = new FileProductDao("productsTest.txt");
        List<Product> expected = new ArrayList<>();
        expected.add(new Product(1, "Milk", 170, true));
        expected.add(new Product(2, "Beer", 210, false));
        assertEquals(expected, productDao.getProducts(ids));
    }


}
