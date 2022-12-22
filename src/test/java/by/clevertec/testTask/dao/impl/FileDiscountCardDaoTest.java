package by.clevertec.testTask.dao.impl;

import by.clevertec.testTask.exeption.DaoException;
import by.clevertec.testTask.model.DiscountCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileDiscountCardDaoTest {

    @Test
    void getCard() throws DaoException {
        FileCardDao cardDao = new FileCardDao("cardsTest.txt");
        int number = 722;
        assertEquals(new DiscountCard(number, 10), cardDao.getCard(number));
    }

    @Test
    void getCardNotNumber() throws DaoException {
        FileCardDao cardDao = new FileCardDao("cardsTest.txt");
        int number = 452;
        assertEquals(new DiscountCard(number, 40), cardDao.getCard(number));
    }

}