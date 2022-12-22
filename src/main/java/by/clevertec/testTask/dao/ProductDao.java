package by.clevertec.testTask.dao;

import by.clevertec.testTask.exeption.DaoException;
import by.clevertec.testTask.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getProducts(List<Integer> ids) throws DaoException;
}
