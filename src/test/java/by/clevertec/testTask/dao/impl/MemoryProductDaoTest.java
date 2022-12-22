package by.clevertec.testTask.dao.impl;

import by.clevertec.testTask.model.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MemoryProductDaoTest {

    @Test
    void getProducts() {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        List<Product> expected = new ArrayList<>();
        expected.add(new Product(1, "Milk", 170, true));
        expected.add(new Product(2, "Beer", 210, false));
        assertEquals(expected, new MemoryProductDao().getProducts(ids));
    }
}
