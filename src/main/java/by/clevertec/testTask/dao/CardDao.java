package by.clevertec.testTask.dao;

import by.clevertec.testTask.model.DiscountCard;
import by.clevertec.testTask.exeption.DaoException;

public interface CardDao {
    DiscountCard getCard(int number) throws DaoException;
}
